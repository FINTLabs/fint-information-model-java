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
import javax.validation.Valid;
import javax.validation.constraints.*;

import no.fint.model.FintMainObject;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.Link;
import no.fint.model.felles.kompleksedatatyper.Periode;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class FravarResource implements FintMainObject, FintLinks {
    // Attributes
    @Deprecated
    @NotNull
    private Boolean dokumentert;
    @NotNull
    private Boolean foresPaVitnemal;
    @NotNull
    private @Valid Periode gjelderPeriode;
    @NotBlank
    private String kommentar;
    @NotNull
    private @Valid Identifikator systemId;

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
    public List<Link> getRegistrertav() {
        return getLinks().getOrDefault("registrertav", Collections.emptyList()); 
    }
    public void addRegistrertav(Link link) {
        addLink("registrertav", link);
    }
    @JsonIgnore
    public List<Link> getUndervisningsgruppe() {
        return getLinks().getOrDefault("undervisningsgruppe", Collections.emptyList()); 
    }
    public void addUndervisningsgruppe(Link link) {
        addLink("undervisningsgruppe", link);
    }
    @Deprecated
    @JsonIgnore
    public List<Link> getEksamensgruppe() {
        return getLinks().getOrDefault("eksamensgruppe", Collections.emptyList()); 
    }
    @Deprecated
    public void addEksamensgruppe(Link link) {
        addLink("eksamensgruppe", link);
    }
    @JsonIgnore
    public List<Link> getFravarstype() {
        return getLinks().getOrDefault("fravarstype", Collections.emptyList()); 
    }
    public void addFravarstype(Link link) {
        addLink("fravarstype", link);
    }
}
