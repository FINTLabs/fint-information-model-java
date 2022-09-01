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

import no.fint.model.FintComplexDatatypeObject;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.Link;
import no.fint.model.felles.kompleksedatatyper.Periode;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class FravarsregistreringResource implements FintComplexDatatypeObject, FintLinks {
    // Attributes
    @NotNull
    private Boolean foresPaVitnemal;
    @NotBlank
    private String kommentar;
    @NotNull
    private @Valid Periode periode;

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
}
