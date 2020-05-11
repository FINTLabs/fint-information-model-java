// Built from tag v3.5.0

package no.fint.model.resource.administrasjon.fullmakt;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import no.fint.model.FintMainObject;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.Link;
import no.fint.model.felles.kompleksedatatyper.Periode;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class FullmaktResource implements FintMainObject, FintLinks {
    // Attributes
    @NonNull
    private Periode gyldighetsperiode;
    @NonNull
    private Identifikator systemId;

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getMyndighet() {
        return getLinks().getOrDefault("myndighet", Collections.emptyList()); 
    }
    public void addMyndighet(Link link) {
        addLink("myndighet", link);
    }
    @JsonIgnore
    public List<Link> getStedfortreder() {
        return getLinks().getOrDefault("stedfortreder", Collections.emptyList()); 
    }
    public void addStedfortreder(Link link) {
        addLink("stedfortreder", link);
    }
    @JsonIgnore
    public List<Link> getFullmektig() {
        return getLinks().getOrDefault("fullmektig", Collections.emptyList()); 
    }
    public void addFullmektig(Link link) {
        addLink("fullmektig", link);
    }
    @JsonIgnore
    public List<Link> getRolle() {
        return getLinks().getOrDefault("rolle", Collections.emptyList()); 
    }
    public void addRolle(Link link) {
        addLink("rolle", link);
    }
}
