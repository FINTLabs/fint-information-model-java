package no.fint.model.resource.utdanning.vurdering;

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
import no.fint.model.FintResource;
import no.fint.model.resource.Link;
import no.fint.model.FintIdentifikator;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class SensorResource implements FintResource, FintLinks {
    // Attributes
    @NotNull
    private Boolean aktiv;
    private Integer sensornummer;
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
    public List<Link> getSkoleressurs() {
        return getLinks().getOrDefault("skoleressurs", Collections.emptyList()); 
    }
    public void addSkoleressurs(Link link) {
        addLink("skoleressurs", link);
    }
    @JsonIgnore
    public List<Link> getEksamensgruppe() {
        return getLinks().getOrDefault("eksamensgruppe", Collections.emptyList()); 
    }
    public void addEksamensgruppe(Link link) {
        addLink("eksamensgruppe", link);
    }
}
