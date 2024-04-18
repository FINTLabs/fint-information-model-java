package no.fint.model.resource.okonomi.faktura;

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
import no.fint.model.FintMainObject;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.Link;
import no.fint.model.FintIdentifikator;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class FakturautstederResource implements FintMainObject, FintLinks {
    // Attributes
    @NotBlank
    private String navn;
    @NotNull
    private @Valid Identifikator systemId;
	@JsonIgnore
	public Map<String, FintIdentifikator> getIdentifikators() {
    	Map<String, FintIdentifikator> identifikators = new HashMap<>();
		identifikators.put("systemId", this.systemId);
    
    	return identifikators;
	}

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getOrganisasjonselement() {
        return getLinks().getOrDefault("organisasjonselement", Collections.emptyList()); 
    }
    public void addOrganisasjonselement(Link link) {
        addLink("organisasjonselement", link);
    }
    @JsonIgnore
    public List<Link> getFakturagrunnlag() {
        return getLinks().getOrDefault("fakturagrunnlag", Collections.emptyList()); 
    }
    public void addFakturagrunnlag(Link link) {
        addLink("fakturagrunnlag", link);
    }
    @JsonIgnore
    public List<Link> getVare() {
        return getLinks().getOrDefault("vare", Collections.emptyList()); 
    }
    public void addVare(Link link) {
        addLink("vare", link);
    }
}
