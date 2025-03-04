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
import no.fint.model.resource.FintResource;
import no.fint.model.resource.Link;
import no.fint.model.FintIdentifikator;
import no.fint.model.resource.utdanning.vurdering.FagvurderingResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class EksamensvurderingResource extends FagvurderingResource implements FintResource {
    @JsonIgnore
    public Map<String, FintIdentifikator> getIdentifikators() {
        Map<String, FintIdentifikator> identifikators = new HashMap<>();
        identifikators.putAll(super.getIdentifikators());

        return Collections.unmodifiableMap(identifikators);
    }

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getEksamensgruppe() {
        return getLinks().getOrDefault("eksamensgruppe", Collections.emptyList()); 
    }
    public void addEksamensgruppe(Link link) {
        addLink("eksamensgruppe", link);
    }
    @JsonIgnore
    public List<Link> getKarakterhistorie() {
        return getLinks().getOrDefault("karakterhistorie", Collections.emptyList()); 
    }
    public void addKarakterhistorie(Link link) {
        addLink("karakterhistorie", link);
    }
    @JsonIgnore
    public List<Link> getElevvurdering() {
        return getLinks().getOrDefault("elevvurdering", Collections.emptyList()); 
    }
    public void addElevvurdering(Link link) {
        addLink("elevvurdering", link);
    }
}
