// Built from tag v3.6.0-rc-1

package no.fint.model.resource.administrasjon.personal;

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
    @NotNull
    private @Valid Periode periode;
    @NotNull
    private Long prosent;
    private @Valid Identifikator systemId;

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getFravarsgrunn() {
        return getLinks().getOrDefault("fravarsgrunn", Collections.emptyList()); 
    }
    public void addFravarsgrunn(Link link) {
        addLink("fravarsgrunn", link);
    }
    @JsonIgnore
    public List<Link> getFravarstype() {
        return getLinks().getOrDefault("fravarstype", Collections.emptyList()); 
    }
    public void addFravarstype(Link link) {
        addLink("fravarstype", link);
    }
    @JsonIgnore
    public List<Link> getArbeidsforhold() {
        return getLinks().getOrDefault("arbeidsforhold", Collections.emptyList()); 
    }
    public void addArbeidsforhold(Link link) {
        addLink("arbeidsforhold", link);
    }
    @JsonIgnore
    public List<Link> getFortsettelse() {
        return getLinks().getOrDefault("fortsettelse", Collections.emptyList()); 
    }
    public void addFortsettelse(Link link) {
        addLink("fortsettelse", link);
    }
    @JsonIgnore
    public List<Link> getFortsetter() {
        return getLinks().getOrDefault("fortsetter", Collections.emptyList()); 
    }
    public void addFortsetter(Link link) {
        addLink("fortsetter", link);
    }
}
