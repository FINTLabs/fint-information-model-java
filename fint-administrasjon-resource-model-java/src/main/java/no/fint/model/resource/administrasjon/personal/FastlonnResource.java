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
import no.fint.model.resource.administrasjon.personal.LonnResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class FastlonnResource extends LonnResource implements FintMainObject, FintLinks {
    // Attributes
    @NotNull
    private Long prosent;

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getLonnsart() {
        return getLinks().getOrDefault("lonnsart", Collections.emptyList()); 
    }
    public void addLonnsart(Link link) {
        addLink("lonnsart", link);
    }
    @JsonIgnore
    public List<Link> getArbeidsforhold() {
        return getLinks().getOrDefault("arbeidsforhold", Collections.emptyList()); 
    }
    public void addArbeidsforhold(Link link) {
        addLink("arbeidsforhold", link);
    }
    @JsonIgnore
    public List<Link> getAnviser() {
        return getLinks().getOrDefault("anviser", Collections.emptyList()); 
    }
    public void addAnviser(Link link) {
        addLink("anviser", link);
    }
    @JsonIgnore
    public List<Link> getKonterer() {
        return getLinks().getOrDefault("konterer", Collections.emptyList()); 
    }
    public void addKonterer(Link link) {
        addLink("konterer", link);
    }
    @JsonIgnore
    public List<Link> getAttestant() {
        return getLinks().getOrDefault("attestant", Collections.emptyList()); 
    }
    public void addAttestant(Link link) {
        addLink("attestant", link);
    }
}
