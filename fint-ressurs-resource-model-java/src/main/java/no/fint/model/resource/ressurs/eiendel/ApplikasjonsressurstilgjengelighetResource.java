package no.fint.model.resource.ressurs.eiendel;

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
import no.fint.model.felles.kompleksedatatyper.Periode;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ApplikasjonsressurstilgjengelighetResource implements FintResource {
    // Attributes
    @NotNull
    private @Valid Periode gyldighetsperiode;
    private Long lisensantall;
    @NotNull
    private @Valid Identifikator systemId;
    @JsonIgnore
    @Override
    public Map<String, FintIdentifikator> getIdentifikators() {
        Map<String, FintIdentifikator> identifikators = new HashMap<>();
        identifikators.put("systemId", this.systemId);

        return Collections.unmodifiableMap(identifikators);
    }

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getKonsument() {
        return getLinks().getOrDefault("konsument", Collections.emptyList()); 
    }
    public void addKonsument(Link link) {
        addLink("konsument", link);
    }
    @JsonIgnore
    public List<Link> getRessurs() {
        return getLinks().getOrDefault("ressurs", Collections.emptyList()); 
    }
    public void addRessurs(Link link) {
        addLink("ressurs", link);
    }
}
