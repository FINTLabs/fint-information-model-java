package no.fint.model.resource.administrasjon.kodeverk;

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
import no.fint.model.resource.administrasjon.kodeverk.KontodimensjonResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class ProsjektartResource extends KontodimensjonResource implements resource.FintResource, FintLinks {
    @JsonIgnore
    public Map<String, FintIdentifikator> getIdentifikators() {
        Map<String, FintIdentifikator> identifikators = new HashMap<>();
        identifikators.putAll(super.getIdentifikators());
    
        return identifikators;
    }

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getUnderordnet() {
        return getLinks().getOrDefault("underordnet", Collections.emptyList()); 
    }
    public void addUnderordnet(Link link) {
        addLink("underordnet", link);
    }
    @JsonIgnore
    public List<Link> getProsjekt() {
        return getLinks().getOrDefault("prosjekt", Collections.emptyList()); 
    }
    public void addProsjekt(Link link) {
        addLink("prosjekt", link);
    }
    @JsonIgnore
    public List<Link> getOverordnet() {
        return getLinks().getOrDefault("overordnet", Collections.emptyList()); 
    }
    public void addOverordnet(Link link) {
        addLink("overordnet", link);
    }
}
