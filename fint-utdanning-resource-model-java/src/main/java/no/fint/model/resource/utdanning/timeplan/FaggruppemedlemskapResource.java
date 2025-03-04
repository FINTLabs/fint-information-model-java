package no.fint.model.resource.utdanning.timeplan;

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
import no.fint.model.utdanning.basisklasser.Gruppemedlemskap;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class FaggruppemedlemskapResource extends Gruppemedlemskap implements FintResource {
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
    public List<Link> getFagmerknad() {
        return getLinks().getOrDefault("fagmerknad", Collections.emptyList()); 
    }
    public void addFagmerknad(Link link) {
        addLink("fagmerknad", link);
    }
    @JsonIgnore
    public List<Link> getFagstatus() {
        return getLinks().getOrDefault("fagstatus", Collections.emptyList()); 
    }
    public void addFagstatus(Link link) {
        addLink("fagstatus", link);
    }
    @JsonIgnore
    public List<Link> getElevforhold() {
        return getLinks().getOrDefault("elevforhold", Collections.emptyList()); 
    }
    public void addElevforhold(Link link) {
        addLink("elevforhold", link);
    }
    @JsonIgnore
    public List<Link> getVarsel() {
        return getLinks().getOrDefault("varsel", Collections.emptyList()); 
    }
    public void addVarsel(Link link) {
        addLink("varsel", link);
    }
    @JsonIgnore
    public List<Link> getFaggruppe() {
        return getLinks().getOrDefault("faggruppe", Collections.emptyList()); 
    }
    public void addFaggruppe(Link link) {
        addLink("faggruppe", link);
    }
}
