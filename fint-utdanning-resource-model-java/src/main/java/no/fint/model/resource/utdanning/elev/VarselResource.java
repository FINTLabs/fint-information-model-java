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
public class VarselResource implements FintResource {
    // Attributes
    @NotNull
    private Long fravarsprosent;
    @NotNull
    private Date sendt;
    @NotNull
    private @Valid Identifikator systemId;
    @NotBlank
    private String tekst;
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
    public List<Link> getUtsteder() {
        return getLinks().getOrDefault("utsteder", Collections.emptyList()); 
    }
    public void addUtsteder(Link link) {
        addLink("utsteder", link);
    }
    @JsonIgnore
    public List<Link> getKarakteransvarlig() {
        return getLinks().getOrDefault("karakteransvarlig", Collections.emptyList()); 
    }
    public void addKarakteransvarlig(Link link) {
        addLink("karakteransvarlig", link);
    }
    @JsonIgnore
    public List<Link> getType() {
        return getLinks().getOrDefault("type", Collections.emptyList()); 
    }
    public void addType(Link link) {
        addLink("type", link);
    }
    @JsonIgnore
    public List<Link> getFaggruppemedlemskap() {
        return getLinks().getOrDefault("faggruppemedlemskap", Collections.emptyList()); 
    }
    public void addFaggruppemedlemskap(Link link) {
        addLink("faggruppemedlemskap", link);
    }
}
