package no.novari.fint.model.resource.arkiv.noark;

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

import no.novari.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.FintResource;
import no.fint.model.resource.Link;
import no.fint.model.FintIdentifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AutorisasjonResource implements FintResource {
    // Attributes
    @NotNull
    private @Valid Identifikator systemId;
    @JsonIgnore
    public Map<String, FintIdentifikator> getIdentifikators() {
        Map<String, FintIdentifikator> identifikators = new HashMap<>();
        identifikators.put("systemId", this.systemId);

        return Collections.unmodifiableMap(identifikators);
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
