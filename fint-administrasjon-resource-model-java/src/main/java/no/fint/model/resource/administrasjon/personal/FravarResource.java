// Built from tag v3.5.0

package no.fint.model.resource.administrasjon.personal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import java.util.Collections;
import java.util.List;
import java.util.Map;

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
    @NonNull
    private Periode periode;
    @NonNull
    private Long prosent;
    private Identifikator systemId;

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
