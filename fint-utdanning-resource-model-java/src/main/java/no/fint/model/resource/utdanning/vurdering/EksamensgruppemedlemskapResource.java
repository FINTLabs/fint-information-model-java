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
import no.fint.model.utdanning.basisklasser.Gruppemedlemskap;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class EksamensgruppemedlemskapResource extends Gruppemedlemskap implements FintMainObject, FintLinks {
    // Attributes
    private Boolean delegert;
    private String kandidatnummer;

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getDelegertTil() {
        return getLinks().getOrDefault("delegertTil", Collections.emptyList()); 
    }
    public void addDelegertTil(Link link) {
        addLink("delegertTil", link);
    }
    @JsonIgnore
    public List<Link> getElevforhold() {
        return getLinks().getOrDefault("elevforhold", Collections.emptyList()); 
    }
    public void addElevforhold(Link link) {
        addLink("elevforhold", link);
    }
    @JsonIgnore
    public List<Link> getForetrukketSkole() {
        return getLinks().getOrDefault("foretrukketSkole", Collections.emptyList()); 
    }
    public void addForetrukketSkole(Link link) {
        addLink("foretrukketSkole", link);
    }
    @JsonIgnore
    public List<Link> getEksamensgruppe() {
        return getLinks().getOrDefault("eksamensgruppe", Collections.emptyList()); 
    }
    public void addEksamensgruppe(Link link) {
        addLink("eksamensgruppe", link);
    }
    @JsonIgnore
    public List<Link> getNus() {
        return getLinks().getOrDefault("nus", Collections.emptyList()); 
    }
    public void addNus(Link link) {
        addLink("nus", link);
    }
    @JsonIgnore
    public List<Link> getForetrukketSensor() {
        return getLinks().getOrDefault("foretrukketSensor", Collections.emptyList()); 
    }
    public void addForetrukketSensor(Link link) {
        addLink("foretrukketSensor", link);
    }
}
