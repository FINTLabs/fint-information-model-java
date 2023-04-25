package no.fint.model.resource.utdanning.ot;

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
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class OTUngdomResource implements FintMainObject, FintLinks {
    // Attributes
    @NotNull
    private @Valid Identifikator systemId;

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getPerson() {
        return getLinks().getOrDefault("person", Collections.emptyList()); 
    }
    public void addPerson(Link link) {
        addLink("person", link);
    }
    @JsonIgnore
    public List<Link> getStatus() {
        return getLinks().getOrDefault("status", Collections.emptyList()); 
    }
    public void addStatus(Link link) {
        addLink("status", link);
    }
    @JsonIgnore
    public List<Link> getProgramomrademedlemskap() {
        return getLinks().getOrDefault("programomrademedlemskap", Collections.emptyList()); 
    }
    public void addProgramomrademedlemskap(Link link) {
        addLink("programomrademedlemskap", link);
    }
    @JsonIgnore
    public List<Link> getEnhet() {
        return getLinks().getOrDefault("enhet", Collections.emptyList()); 
    }
    public void addEnhet(Link link) {
        addLink("enhet", link);
    }
}
