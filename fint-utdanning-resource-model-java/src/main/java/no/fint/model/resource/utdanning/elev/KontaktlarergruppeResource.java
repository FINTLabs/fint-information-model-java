package no.fint.model.resource.utdanning.elev;

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
import no.fint.model.resource.utdanning.basisklasser.GruppeResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class KontaktlarergruppeResource extends GruppeResource implements FintMainObject, FintLinks {

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getBasisgruppe() {
        return getLinks().getOrDefault("basisgruppe", Collections.emptyList()); 
    }
    public void addBasisgruppe(Link link) {
        addLink("basisgruppe", link);
    }
    @JsonIgnore
    public List<Link> getElevforhold() {
        return getLinks().getOrDefault("elevforhold", Collections.emptyList()); 
    }
    public void addElevforhold(Link link) {
        addLink("elevforhold", link);
    }
    @JsonIgnore
    public List<Link> getTermin() {
        return getLinks().getOrDefault("termin", Collections.emptyList()); 
    }
    public void addTermin(Link link) {
        addLink("termin", link);
    }
    @JsonIgnore
    public List<Link> getSkole() {
        return getLinks().getOrDefault("skole", Collections.emptyList()); 
    }
    public void addSkole(Link link) {
        addLink("skole", link);
    }
    @JsonIgnore
    public List<Link> getSkolear() {
        return getLinks().getOrDefault("skolear", Collections.emptyList()); 
    }
    public void addSkolear(Link link) {
        addLink("skolear", link);
    }
    @JsonIgnore
    public List<Link> getUndervisningsforhold() {
        return getLinks().getOrDefault("undervisningsforhold", Collections.emptyList()); 
    }
    public void addUndervisningsforhold(Link link) {
        addLink("undervisningsforhold", link);
    }
    @JsonIgnore
    public List<Link> getGruppemedlemskap() {
        return getLinks().getOrDefault("gruppemedlemskap", Collections.emptyList()); 
    }
    public void addGruppemedlemskap(Link link) {
        addLink("gruppemedlemskap", link);
    }
}
