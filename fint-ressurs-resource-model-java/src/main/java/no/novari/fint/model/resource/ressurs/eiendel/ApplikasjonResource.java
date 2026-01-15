package no.novari.fint.model.resource.ressurs.eiendel;

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

import no.novari.fint.model.felles.kompleksedatatyper.Identifikator;
import no.novari.fint.model.resource.FintLinks;
import no.novari.fint.model.resource.FintResource;
import no.novari.fint.model.resource.Link;
import no.novari.fint.model.FintIdentifikator;
import no.novari.fint.model.felles.kompleksedatatyper.Periode;
import no.novari.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ApplikasjonResource implements FintResource {
    // Attributes
    private String beskrivelse;
    @NotNull
    private @Valid Periode gyldighetsperiode;
    @NotBlank
    private String navn;
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
    public List<Link> getPlattform() {
        return getLinks().getOrDefault("plattform", Collections.emptyList()); 
    }
    public void addPlattform(Link link) {
        addLink("plattform", link);
    }
    @JsonIgnore
    public List<Link> getRessurs() {
        return getLinks().getOrDefault("ressurs", Collections.emptyList()); 
    }
    public void addRessurs(Link link) {
        addLink("ressurs", link);
    }
    @JsonIgnore
    public List<Link> getApplikasjonskategori() {
        return getLinks().getOrDefault("applikasjonskategori", Collections.emptyList()); 
    }
    public void addApplikasjonskategori(Link link) {
        addLink("applikasjonskategori", link);
    }
}
