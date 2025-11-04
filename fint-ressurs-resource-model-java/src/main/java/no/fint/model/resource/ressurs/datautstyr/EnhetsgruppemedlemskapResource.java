package no.fint.model.resource.ressurs.datautstyr;

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
public class EnhetsgruppemedlemskapResource implements FintResource {
    // Attributes
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
    public List<Link> getDigitalEnhet() {
        return getLinks().getOrDefault("digitalEnhet", Collections.emptyList()); 
    }
    public void addDigitalEnhet(Link link) {
        addLink("digitalEnhet", link);
    }
    @JsonIgnore
    public List<Link> getEnhetsgruppe() {
        return getLinks().getOrDefault("enhetsgruppe", Collections.emptyList()); 
    }
    public void addEnhetsgruppe(Link link) {
        addLink("enhetsgruppe", link);
    }
}
