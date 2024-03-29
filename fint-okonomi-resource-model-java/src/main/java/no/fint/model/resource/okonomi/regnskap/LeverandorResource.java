package no.fint.model.resource.okonomi.regnskap;

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
public class LeverandorResource implements FintMainObject, FintLinks {
    // Attributes
    private String kontonummer;
    private @Valid Identifikator leverandornummer;
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
    public List<Link> getLeverandorgruppe() {
        return getLinks().getOrDefault("leverandorgruppe", Collections.emptyList()); 
    }
    public void addLeverandorgruppe(Link link) {
        addLink("leverandorgruppe", link);
    }
    @JsonIgnore
    public List<Link> getVirksomhet() {
        return getLinks().getOrDefault("virksomhet", Collections.emptyList()); 
    }
    public void addVirksomhet(Link link) {
        addLink("virksomhet", link);
    }
}
