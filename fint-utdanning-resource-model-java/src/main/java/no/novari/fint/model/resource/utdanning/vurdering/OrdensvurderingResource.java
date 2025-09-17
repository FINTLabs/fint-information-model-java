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
import no.fint.model.resource.FintLinks;
import no.fint.model.FintAbstractObject;
import no.fint.model.resource.Link;
import no.fint.model.FintIdentifikator;

import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class OrdensvurderingResource implements FintAbstractObject, FintLinks {
    // Attributes
    @NotBlank
    private String kommentar;
    @NotNull
    private @Valid Identifikator systemId;
    @NotNull
    private Date vurderingsdato;
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
    public List<Link> getAtferd() {
        return getLinks().getOrDefault("atferd", Collections.emptyList()); 
    }
    public void addAtferd(Link link) {
        addLink("atferd", link);
    }
    @JsonIgnore
    public List<Link> getOrden() {
        return getLinks().getOrDefault("orden", Collections.emptyList()); 
    }
    public void addOrden(Link link) {
        addLink("orden", link);
    }
    @JsonIgnore
    public List<Link> getSkolear() {
        return getLinks().getOrDefault("skolear", Collections.emptyList()); 
    }
    public void addSkolear(Link link) {
        addLink("skolear", link);
    }
}
