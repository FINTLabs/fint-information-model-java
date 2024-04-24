package no.fint.model.resource.okonomi.regnskap;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.validation.Valid;
import javax.validation.constraints.*;

import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.FintResource;
import no.fint.model.resource.Link;
import no.fint.model.FintIdentifikator;
import no.fint.model.okonomi.regnskap.Bilag;
import java.util.Date;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class TransaksjonResource implements FintResource, FintLinks {
    // Attributes
    @NotNull
    private Long belop;
    private String beskrivelse;
    private List<@Valid Bilag> bilag;
    @NotNull
    private Date forfallsdato;
    private Date oppdateringstidspunkt;
    private @Valid Identifikator transaksjonsId;
    private Date transaksjonstidspunkt;
	@JsonIgnore
	public Map<String, FintIdentifikator> getIdentifikators() {
    	Map<String, FintIdentifikator> identifikators = new HashMap<>();
		identifikators.put("transaksjonsId", this.transaksjonsId);
    
    	return identifikators;
	}

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getLeverandor() {
        return getLinks().getOrDefault("leverandor", Collections.emptyList()); 
    }
    public void addLeverandor(Link link) {
        addLink("leverandor", link);
    }
    @JsonIgnore
    public List<Link> getAnsvarlig() {
        return getLinks().getOrDefault("ansvarlig", Collections.emptyList()); 
    }
    public void addAnsvarlig(Link link) {
        addLink("ansvarlig", link);
    }
    @JsonIgnore
    public List<Link> getValuta() {
        return getLinks().getOrDefault("valuta", Collections.emptyList()); 
    }
    public void addValuta(Link link) {
        addLink("valuta", link);
    }
    @JsonIgnore
    public List<Link> getPostering() {
        return getLinks().getOrDefault("postering", Collections.emptyList()); 
    }
    public void addPostering(Link link) {
        addLink("postering", link);
    }
}
