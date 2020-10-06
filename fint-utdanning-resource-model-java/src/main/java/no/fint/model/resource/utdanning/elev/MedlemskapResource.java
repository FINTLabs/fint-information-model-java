// Built from tag v3.6.0-rc-1

package no.fint.model.resource.utdanning.elev;

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

import no.fint.model.FintMainObject;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.Link;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Deprecated
public class MedlemskapResource implements FintMainObject, FintLinks {
    // Attributes
    @Deprecated
    @NotNull
    private @Valid Identifikator systemId;

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @Deprecated
    @JsonIgnore
    public List<Link> getMedlem() {
        return getLinks().getOrDefault("medlem", Collections.emptyList()); 
    }
    @Deprecated
    public void addMedlem(Link link) {
        addLink("medlem", link);
    }
    @Deprecated
    @JsonIgnore
    public List<Link> getFortlopendeVurdering() {
        return getLinks().getOrDefault("fortlopendeVurdering", Collections.emptyList()); 
    }
    @Deprecated
    public void addFortlopendeVurdering(Link link) {
        addLink("fortlopendeVurdering", link);
    }
    @Deprecated
    @JsonIgnore
    public List<Link> getGruppe() {
        return getLinks().getOrDefault("gruppe", Collections.emptyList()); 
    }
    @Deprecated
    public void addGruppe(Link link) {
        addLink("gruppe", link);
    }
    @Deprecated
    @JsonIgnore
    public List<Link> getEndeligVurdering() {
        return getLinks().getOrDefault("endeligVurdering", Collections.emptyList()); 
    }
    @Deprecated
    public void addEndeligVurdering(Link link) {
        addLink("endeligVurdering", link);
    }
    @Deprecated
    @JsonIgnore
    public List<Link> getFravar() {
        return getLinks().getOrDefault("fravar", Collections.emptyList()); 
    }
    @Deprecated
    public void addFravar(Link link) {
        addLink("fravar", link);
    }
}
