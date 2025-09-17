package no.novari.fint.model.resource.arkiv.noark;

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
import no.novari.fint.model.FintAbstractObject;
import no.novari.fint.model.resource.Link;
import no.novari.fint.model.FintIdentifikator;

import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public abstract class SaksmappeResource extends MappeResource implements FintAbstractObject, FintLinks {
    // Attributes
    @JsonIgnore
    @Override
    public List<FintLinks> getNestedResources() {
        List<FintLinks> result = super.getNestedResources();
        if (arkivnotat != null) {
            result.addAll(arkivnotat);
        }
        if (journalpost != null) {
            result.addAll(journalpost);
        }
        return result;
    }
    private List<@Valid RegistreringResource> arkivnotat;
    private List<@Valid JournalpostResource> journalpost;
    private String saksaar;
    private @Valid Date saksdato;
    private String sakssekvensnummer;
    private @Valid Date utlaantDato;
    @JsonIgnore
    public Map<String, FintIdentifikator> getIdentifikators() {
        Map<String, FintIdentifikator> identifikators = new HashMap<>();
        identifikators.putAll(super.getIdentifikators());

        return Collections.unmodifiableMap(identifikators);
    }

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getSaksmappetype() {
        return getLinks().getOrDefault("saksmappetype", Collections.emptyList()); 
    }
    public void addSaksmappetype(Link link) {
        addLink("saksmappetype", link);
    }
    @JsonIgnore
    public List<Link> getSaksstatus() {
        return getLinks().getOrDefault("saksstatus", Collections.emptyList()); 
    }
    public void addSaksstatus(Link link) {
        addLink("saksstatus", link);
    }
    @JsonIgnore
    public List<Link> getTilgangsgruppe() {
        return getLinks().getOrDefault("tilgangsgruppe", Collections.emptyList()); 
    }
    public void addTilgangsgruppe(Link link) {
        addLink("tilgangsgruppe", link);
    }
    @JsonIgnore
    public List<Link> getJournalenhet() {
        return getLinks().getOrDefault("journalenhet", Collections.emptyList()); 
    }
    public void addJournalenhet(Link link) {
        addLink("journalenhet", link);
    }
    @JsonIgnore
    public List<Link> getAdministrativEnhet() {
        return getLinks().getOrDefault("administrativEnhet", Collections.emptyList()); 
    }
    public void addAdministrativEnhet(Link link) {
        addLink("administrativEnhet", link);
    }
    @JsonIgnore
    public List<Link> getSaksansvarlig() {
        return getLinks().getOrDefault("saksansvarlig", Collections.emptyList()); 
    }
    public void addSaksansvarlig(Link link) {
        addLink("saksansvarlig", link);
    }
}
