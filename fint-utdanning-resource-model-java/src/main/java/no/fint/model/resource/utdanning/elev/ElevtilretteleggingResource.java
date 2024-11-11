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
import java.util.HashMap;
import javax.validation.Valid;
import javax.validation.constraints.*;

import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.FintResource;
import no.fint.model.resource.Link;
import no.fint.model.FintIdentifikator;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ElevtilretteleggingResource implements FintResource {
    // Attributes
    @NotNull
    private @Valid Identifikator systemId;
    @JsonIgnore
    private final Map<String, FintIdentifikator> identifikators = createIdentifikators();

    @JsonIgnore
    private Map<String, FintIdentifikator> createIdentifikators() {
        Map<String, FintIdentifikator> identifikators = new HashMap<>();
        identifikators.put("systemId", this.systemId);

        return Collections.unmodifiableMap(identifikators);
    }

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getElev() {
        return getLinks().getOrDefault("elev", Collections.emptyList()); 
    }
    public void addElev(Link link) {
        addLink("elev", link);
    }
    @JsonIgnore
    public List<Link> getFag() {
        return getLinks().getOrDefault("fag", Collections.emptyList()); 
    }
    public void addFag(Link link) {
        addLink("fag", link);
    }
    @JsonIgnore
    public List<Link> getTilrettelegging() {
        return getLinks().getOrDefault("tilrettelegging", Collections.emptyList()); 
    }
    public void addTilrettelegging(Link link) {
        addLink("tilrettelegging", link);
    }
    @JsonIgnore
    public List<Link> getEksamensform() {
        return getLinks().getOrDefault("eksamensform", Collections.emptyList()); 
    }
    public void addEksamensform(Link link) {
        addLink("eksamensform", link);
    }
}
