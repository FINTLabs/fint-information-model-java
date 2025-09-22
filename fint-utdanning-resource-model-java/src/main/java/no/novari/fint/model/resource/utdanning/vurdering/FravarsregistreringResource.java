package no.novari.fint.model.resource.utdanning.vurdering;

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
public class FravarsregistreringResource implements FintResource {
    // Attributes
    @NotNull
    private Boolean foresPaVitnemal;
    private String kommentar;
    @NotNull
    private @Valid Periode periode;
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
    public List<Link> getRegistrertAv() {
        return getLinks().getOrDefault("registrertAv", Collections.emptyList()); 
    }
    public void addRegistrertAv(Link link) {
        addLink("registrertAv", link);
    }
    @JsonIgnore
    public List<Link> getFaggruppe() {
        return getLinks().getOrDefault("faggruppe", Collections.emptyList()); 
    }
    public void addFaggruppe(Link link) {
        addLink("faggruppe", link);
    }
    @JsonIgnore
    public List<Link> getUndervisningsgruppe() {
        return getLinks().getOrDefault("undervisningsgruppe", Collections.emptyList()); 
    }
    public void addUndervisningsgruppe(Link link) {
        addLink("undervisningsgruppe", link);
    }
    @JsonIgnore
    public List<Link> getFravarstype() {
        return getLinks().getOrDefault("fravarstype", Collections.emptyList()); 
    }
    public void addFravarstype(Link link) {
        addLink("fravarstype", link);
    }
    @JsonIgnore
    public List<Link> getElevfravar() {
        return getLinks().getOrDefault("elevfravar", Collections.emptyList()); 
    }
    public void addElevfravar(Link link) {
        addLink("elevfravar", link);
    }
}
