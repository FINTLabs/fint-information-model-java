package no.fint.model.resource.personvern.samtykke;

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
import javax.validation.constraints.*;

import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.FintResource;
import no.fint.model.resource.Link;
import no.fint.model.FintIdentifikator;
import java.util.Date;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class BehandlingResource implements resource.FintResource, FintLinks {
    // Attributes
    @NotNull
    private Boolean aktiv;
    @NotBlank
    private String formal;
    private @Valid Date slettet;
    @NotNull
    private @Valid Identifikator systemId;
    @JsonIgnore
    public Map<String, FintIdentifikator> getIdentifikators() {
        Map<String, FintIdentifikator> identifikators = new HashMap<>();
        identifikators.put("systemId", this.systemId);
    
        return identifikators;
    }

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getBehandlingsgrunnlag() {
        return getLinks().getOrDefault("behandlingsgrunnlag", Collections.emptyList()); 
    }
    public void addBehandlingsgrunnlag(Link link) {
        addLink("behandlingsgrunnlag", link);
    }
    @JsonIgnore
    public List<Link> getPersonopplysning() {
        return getLinks().getOrDefault("personopplysning", Collections.emptyList()); 
    }
    public void addPersonopplysning(Link link) {
        addLink("personopplysning", link);
    }
    @JsonIgnore
    public List<Link> getSamtykke() {
        return getLinks().getOrDefault("samtykke", Collections.emptyList()); 
    }
    public void addSamtykke(Link link) {
        addLink("samtykke", link);
    }
    @JsonIgnore
    public List<Link> getTjeneste() {
        return getLinks().getOrDefault("tjeneste", Collections.emptyList()); 
    }
    public void addTjeneste(Link link) {
        addLink("tjeneste", link);
    }
}
