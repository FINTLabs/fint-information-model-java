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
import no.fint.model.utdanning.vurdering.Fravarsprosent;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class FravarsoversiktResource implements FintResource {
    // Attributes
    @NotNull
    private @Valid Fravarsprosent halvar;
    @NotNull
    private @Valid Fravarsprosent skolear;
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
    public List<Link> getElevforhold() {
        return getLinks().getOrDefault("elevforhold", Collections.emptyList()); 
    }
    public void addElevforhold(Link link) {
        addLink("elevforhold", link);
    }
    @JsonIgnore
    public List<Link> getFag() {
        return getLinks().getOrDefault("fag", Collections.emptyList()); 
    }
    public void addFag(Link link) {
        addLink("fag", link);
    }
}
