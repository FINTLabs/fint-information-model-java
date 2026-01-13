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

import no.novari.fint.model.resource.FintLinks;
import no.novari.fint.model.resource.FintResource;
import no.novari.fint.model.resource.Link;
import no.novari.fint.model.FintIdentifikator;
import java.util.Date;
import no.novari.fint.model.resource.utdanning.basisklasser.GruppeResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class EksamensgruppeResource extends GruppeResource implements FintResource {
    // Attributes
    private @Valid Date eksamensdato;
    @JsonIgnore
    public Map<String, FintIdentifikator> getIdentifikators() {
        Map<String, FintIdentifikator> identifikators = new HashMap<>();
        identifikators.putAll(super.getIdentifikators());

        return Collections.unmodifiableMap(identifikators);
    }

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @Deprecated
    @JsonIgnore
    public List<Link> getElevforhold() {
        return getLinks().getOrDefault("elevforhold", Collections.emptyList()); 
    }
    @Deprecated
    public void addElevforhold(Link link) {
        addLink("elevforhold", link);
    }
    @JsonIgnore
    public List<Link> getEksamen() {
        return getLinks().getOrDefault("eksamen", Collections.emptyList()); 
    }
    public void addEksamen(Link link) {
        addLink("eksamen", link);
    }
    @JsonIgnore
    public List<Link> getFag() {
        return getLinks().getOrDefault("fag", Collections.emptyList()); 
    }
    public void addFag(Link link) {
        addLink("fag", link);
    }
    @JsonIgnore
    public List<Link> getSkole() {
        return getLinks().getOrDefault("skole", Collections.emptyList()); 
    }
    public void addSkole(Link link) {
        addLink("skole", link);
    }
    @JsonIgnore
    public List<Link> getTermin() {
        return getLinks().getOrDefault("termin", Collections.emptyList()); 
    }
    public void addTermin(Link link) {
        addLink("termin", link);
    }
    @JsonIgnore
    public List<Link> getEksamensform() {
        return getLinks().getOrDefault("eksamensform", Collections.emptyList()); 
    }
    public void addEksamensform(Link link) {
        addLink("eksamensform", link);
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
    @JsonIgnore
    public List<Link> getSensor() {
        return getLinks().getOrDefault("sensor", Collections.emptyList()); 
    }
    public void addSensor(Link link) {
        addLink("sensor", link);
    }
}
