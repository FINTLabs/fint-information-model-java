// Built from tag v3.5.0

package no.fint.model.resource.utdanning.utdanningsprogram;

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
import no.fint.model.utdanning.basisklasser.Gruppe;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class ProgramomradeResource extends Gruppe implements FintMainObject, FintLinks {

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
    public List<Link> getUtdanningsprogram() {
        return getLinks().getOrDefault("utdanningsprogram", Collections.emptyList()); 
    }
    public void addUtdanningsprogram(Link link) {
        addLink("utdanningsprogram", link);
    }
    @JsonIgnore
    public List<Link> getFag() {
        return getLinks().getOrDefault("fag", Collections.emptyList()); 
    }
    public void addFag(Link link) {
        addLink("fag", link);
    }
    @JsonIgnore
    public List<Link> getTrinn() {
        return getLinks().getOrDefault("trinn", Collections.emptyList()); 
    }
    public void addTrinn(Link link) {
        addLink("trinn", link);
    }
    @JsonIgnore
    public List<Link> getGruppemedlemskap() {
        return getLinks().getOrDefault("gruppemedlemskap", Collections.emptyList()); 
    }
    public void addGruppemedlemskap(Link link) {
        addLink("gruppemedlemskap", link);
    }
    @JsonIgnore
    public List<Link> getGrepreferanse() {
        return getLinks().getOrDefault("grepreferanse", Collections.emptyList()); 
    }
    public void addGrepreferanse(Link link) {
        addLink("grepreferanse", link);
    }
    @JsonIgnore
    public List<Link> getVigoreferanse() {
        return getLinks().getOrDefault("vigoreferanse", Collections.emptyList()); 
    }
    public void addVigoreferanse(Link link) {
        addLink("vigoreferanse", link);
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
