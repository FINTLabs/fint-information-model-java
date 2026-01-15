package no.novari.fint.model.resource.felles;

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

import no.novari.fint.model.resource.FintLinks;
import no.novari.fint.model.resource.FintResource;
import no.novari.fint.model.resource.Link;
import no.novari.fint.model.FintIdentifikator;
import no.novari.fint.model.felles.kompleksedatatyper.Kontaktinformasjon;
import no.novari.fint.model.felles.kompleksedatatyper.Personnavn;
import no.novari.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class KontaktpersonResource implements FintResource {
    // Attributes
    private @Valid Kontaktinformasjon kontaktinformasjon;
    private @Valid Personnavn navn;
    @NotNull
    private @Valid Identifikator systemId;
    @NotBlank
    private String type;
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
    public List<Link> getKontaktperson() {
        return getLinks().getOrDefault("kontaktperson", Collections.emptyList()); 
    }
    public void addKontaktperson(Link link) {
        addLink("kontaktperson", link);
    }
}
