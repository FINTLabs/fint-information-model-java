package no.fint.model.resource.arkiv.noark;

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
public class ArkivdelResource implements FintResource, FintLinks {
    // Attributes
    @NotNull
    private @Valid Identifikator systemId;
    @NotBlank
    private String tittel;
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
    public List<Link> getKlassifikasjonssystem() {
        return getLinks().getOrDefault("klassifikasjonssystem", Collections.emptyList()); 
    }
    public void addKlassifikasjonssystem(Link link) {
        addLink("klassifikasjonssystem", link);
    }
    @JsonIgnore
    public List<Link> getRegistrering() {
        return getLinks().getOrDefault("registrering", Collections.emptyList()); 
    }
    public void addRegistrering(Link link) {
        addLink("registrering", link);
    }
    @JsonIgnore
    public List<Link> getMappe() {
        return getLinks().getOrDefault("mappe", Collections.emptyList()); 
    }
    public void addMappe(Link link) {
        addLink("mappe", link);
    }
}
