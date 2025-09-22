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
import javax.validation.constraints.*;

import no.novari.fint.model.felles.kompleksedatatyper.Identifikator;
import no.novari.fint.model.resource.FintLinks;
import no.novari.fint.model.resource.FintResource;
import no.novari.fint.model.resource.Link;
import no.novari.fint.model.FintIdentifikator;
import java.util.Date;
import no.novari.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class KarakterhistorieResource implements FintResource {
    // Attributes
    @NotNull
    private @Valid Date endretDato;
    @NotNull
    private @Valid Identifikator systemId;
    @JsonIgnore
    public Map<String, FintIdentifikator> getIdentifikators() {
        Map<String, FintIdentifikator> identifikators = new HashMap<>();
        identifikators.put("systemId", this.systemId);

        return Collections.unmodifiableMap(identifikators);
    }

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getOppdatertAv() {
        return getLinks().getOrDefault("oppdatertAv", Collections.emptyList()); 
    }
    public void addOppdatertAv(Link link) {
        addLink("oppdatertAv", link);
    }
    @JsonIgnore
    public List<Link> getOpprinneligKarakterverdi() {
        return getLinks().getOrDefault("opprinneligKarakterverdi", Collections.emptyList()); 
    }
    public void addOpprinneligKarakterverdi(Link link) {
        addLink("opprinneligKarakterverdi", link);
    }
    @JsonIgnore
    public List<Link> getOpprinneligKarakterstatus() {
        return getLinks().getOrDefault("opprinneligKarakterstatus", Collections.emptyList()); 
    }
    public void addOpprinneligKarakterstatus(Link link) {
        addLink("opprinneligKarakterstatus", link);
    }
    @JsonIgnore
    public List<Link> getKarakterverdi() {
        return getLinks().getOrDefault("karakterverdi", Collections.emptyList()); 
    }
    public void addKarakterverdi(Link link) {
        addLink("karakterverdi", link);
    }
    @JsonIgnore
    public List<Link> getKarakterstatus() {
        return getLinks().getOrDefault("karakterstatus", Collections.emptyList()); 
    }
    public void addKarakterstatus(Link link) {
        addLink("karakterstatus", link);
    }
}
