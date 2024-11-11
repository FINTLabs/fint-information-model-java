package no.fint.model.resource.okonomi.regnskap;

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
public class LeverandorgruppeResource implements FintResource {
    // Attributes
    @NotBlank
    private String navn;
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
    public List<Link> getLeverandor() {
        return getLinks().getOrDefault("leverandor", Collections.emptyList()); 
    }
    public void addLeverandor(Link link) {
        addLink("leverandor", link);
    }
}
