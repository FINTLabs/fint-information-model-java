package no.fint.model.resource.utdanning.larling;

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
import java.util.Date;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AvlagtProveResource implements FintResource {
    // Attributes
    private Date provedato;
    @NotNull
    private @Valid Identifikator systemId;
    @JsonIgnore
    @Override
    private Map<String, FintIdentifikator> getIdentifikators() {
        Map<String, FintIdentifikator> identifikators = new HashMap<>();
        identifikators.put("systemId", this.systemId);

        return Collections.unmodifiableMap(identifikators);
    }

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getProvestatus() {
        return getLinks().getOrDefault("provestatus", Collections.emptyList()); 
    }
    public void addProvestatus(Link link) {
        addLink("provestatus", link);
    }
    @JsonIgnore
    public List<Link> getLarling() {
        return getLinks().getOrDefault("larling", Collections.emptyList()); 
    }
    public void addLarling(Link link) {
        addLink("larling", link);
    }
    @JsonIgnore
    public List<Link> getFullfortkode() {
        return getLinks().getOrDefault("fullfortkode", Collections.emptyList()); 
    }
    public void addFullfortkode(Link link) {
        addLink("fullfortkode", link);
    }
    @JsonIgnore
    public List<Link> getBrevtype() {
        return getLinks().getOrDefault("brevtype", Collections.emptyList()); 
    }
    public void addBrevtype(Link link) {
        addLink("brevtype", link);
    }
    @JsonIgnore
    public List<Link> getBevistype() {
        return getLinks().getOrDefault("bevistype", Collections.emptyList()); 
    }
    public void addBevistype(Link link) {
        addLink("bevistype", link);
    }
}
