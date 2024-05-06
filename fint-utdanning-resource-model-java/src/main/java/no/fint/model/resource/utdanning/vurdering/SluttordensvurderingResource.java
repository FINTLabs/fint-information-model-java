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
import no.fint.model.FintResourceObject;
import no.fint.model.resource.Link;
import no.fint.model.FintIdentifikator;
import no.fint.model.resource.utdanning.vurdering.OrdensvurderingResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class SluttordensvurderingResource extends OrdensvurderingResource implements FintResourceObject, FintLinks {
    @JsonIgnore
    public Map<String, FintIdentifikator> getIdentifikators() {
        Map<String, FintIdentifikator> identifikators = new HashMap<>();
        identifikators.putAll(super.getIdentifikators());
    
        return identifikators;
    }

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @Deprecated
    @JsonIgnore
    public List<Link> getElevforhold() {
        return getLinks().getOrDefault("elevforhold", Collections.emptyList()); 
    }
    @Deprecated
    public void addElevforhold(Link link) {
        addLink("elevforhold", link);
    }
    @JsonIgnore
    public List<Link> getVurdering() {
        return getLinks().getOrDefault("vurdering", Collections.emptyList()); 
    }
    public void addVurdering(Link link) {
        addLink("vurdering", link);
    }
}
