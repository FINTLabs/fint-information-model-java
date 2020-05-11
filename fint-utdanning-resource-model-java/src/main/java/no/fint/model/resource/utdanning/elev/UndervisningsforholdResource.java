// Built from tag v3.5.0

package no.fint.model.resource.utdanning.elev;

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
import no.fint.model.utdanning.basisklasser.Utdanningsforhold;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class UndervisningsforholdResource extends Utdanningsforhold implements FintMainObject, FintLinks {

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getArbeidsforhold() {
        return getLinks().getOrDefault("arbeidsforhold", Collections.emptyList()); 
    }
    public void addArbeidsforhold(Link link) {
        addLink("arbeidsforhold", link);
    }
    @JsonIgnore
    public List<Link> getBasisgruppe() {
        return getLinks().getOrDefault("basisgruppe", Collections.emptyList()); 
    }
    public void addBasisgruppe(Link link) {
        addLink("basisgruppe", link);
    }
    @JsonIgnore
    public List<Link> getKontaktlarergruppe() {
        return getLinks().getOrDefault("kontaktlarergruppe", Collections.emptyList()); 
    }
    public void addKontaktlarergruppe(Link link) {
        addLink("kontaktlarergruppe", link);
    }
    @JsonIgnore
    public List<Link> getUndervisningsgruppe() {
        return getLinks().getOrDefault("undervisningsgruppe", Collections.emptyList()); 
    }
    public void addUndervisningsgruppe(Link link) {
        addLink("undervisningsgruppe", link);
    }
    @JsonIgnore
    public List<Link> getEksamensgruppe() {
        return getLinks().getOrDefault("eksamensgruppe", Collections.emptyList()); 
    }
    public void addEksamensgruppe(Link link) {
        addLink("eksamensgruppe", link);
    }
    @JsonIgnore
    public List<Link> getTime() {
        return getLinks().getOrDefault("time", Collections.emptyList()); 
    }
    public void addTime(Link link) {
        addLink("time", link);
    }
    @JsonIgnore
    public List<Link> getSkole() {
        return getLinks().getOrDefault("skole", Collections.emptyList()); 
    }
    public void addSkole(Link link) {
        addLink("skole", link);
    }
    @JsonIgnore
    public List<Link> getSkoleressurs() {
        return getLinks().getOrDefault("skoleressurs", Collections.emptyList()); 
    }
    public void addSkoleressurs(Link link) {
        addLink("skoleressurs", link);
    }
    @Deprecated
    @JsonIgnore
    public List<Link> getMedlemskap() {
        return getLinks().getOrDefault("medlemskap", Collections.emptyList()); 
    }
    @Deprecated
    public void addMedlemskap(Link link) {
        addLink("medlemskap", link);
    }
}
