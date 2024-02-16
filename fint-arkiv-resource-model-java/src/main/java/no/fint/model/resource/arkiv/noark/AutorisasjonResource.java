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
import javax.validation.Valid;
import javax.validation.constraints.*;

import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.FintMainObject;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.Link;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AutorisasjonResource implements FintMainObject, FintLinks {
    // Attributes
    @NotNull
    private @Valid Identifikator systemId;

    public Map<String, Identifikator> getIdentifikators() {
    	Map<String, Identifikator> identifikators = new HashMap<>();
		identifikators.put("systemId", this.systemId);
    
    	return identifikators;
	}

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getTilgangsrestriksjon() {
        return getLinks().getOrDefault("tilgangsrestriksjon", Collections.emptyList()); 
    }
    public void addTilgangsrestriksjon(Link link) {
        addLink("tilgangsrestriksjon", link);
    }
    @JsonIgnore
    public List<Link> getAdministrativenhet() {
        return getLinks().getOrDefault("administrativenhet", Collections.emptyList()); 
    }
    public void addAdministrativenhet(Link link) {
        addLink("administrativenhet", link);
    }
    @JsonIgnore
    public List<Link> getArkivressurs() {
        return getLinks().getOrDefault("arkivressurs", Collections.emptyList()); 
    }
    public void addArkivressurs(Link link) {
        addLink("arkivressurs", link);
    }
}
