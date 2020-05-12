// Built from tag v3.5.0

package no.fint.model.resource.administrasjon.organisasjon;

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
import no.fint.model.resource.felles.basisklasser.EnhetResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class OrganisasjonselementResource extends EnhetResource implements FintMainObject, FintLinks {
    // Attributes
    private @Valid Periode gyldighetsperiode;
    private String kortnavn;
    private String navn;
    @NotNull
    private @Valid Identifikator organisasjonsId;
    @NotNull
    private @Valid Identifikator organisasjonsKode;

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getAnsvar() {
        return getLinks().getOrDefault("ansvar", Collections.emptyList()); 
    }
    public void addAnsvar(Link link) {
        addLink("ansvar", link);
    }
    @JsonIgnore
    public List<Link> getLeder() {
        return getLinks().getOrDefault("leder", Collections.emptyList()); 
    }
    public void addLeder(Link link) {
        addLink("leder", link);
    }
    @JsonIgnore
    public List<Link> getOverordnet() {
        return getLinks().getOrDefault("overordnet", Collections.emptyList()); 
    }
    public void addOverordnet(Link link) {
        addLink("overordnet", link);
    }
    @JsonIgnore
    public List<Link> getUnderordnet() {
        return getLinks().getOrDefault("underordnet", Collections.emptyList()); 
    }
    public void addUnderordnet(Link link) {
        addLink("underordnet", link);
    }
    @JsonIgnore
    public List<Link> getSkole() {
        return getLinks().getOrDefault("skole", Collections.emptyList()); 
    }
    public void addSkole(Link link) {
        addLink("skole", link);
    }
    @JsonIgnore
    public List<Link> getArbeidsforhold() {
        return getLinks().getOrDefault("arbeidsforhold", Collections.emptyList()); 
    }
    public void addArbeidsforhold(Link link) {
        addLink("arbeidsforhold", link);
    }
}
