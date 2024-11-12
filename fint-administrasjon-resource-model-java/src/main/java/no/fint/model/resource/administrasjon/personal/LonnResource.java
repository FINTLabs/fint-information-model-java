package no.fint.model.resource.administrasjon.personal;

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
import no.fint.model.FintAbstractObject;
import no.fint.model.resource.Link;
import no.fint.model.FintIdentifikator;
import java.util.Date;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.administrasjon.kompleksedatatyper.KontostrengResource;
import no.fint.model.felles.kompleksedatatyper.Periode;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class LonnResource implements FintAbstractObject, FintLinks {
    // Attributes
    @JsonIgnore
    @Override
    public List<FintLinks> getNestedResources() {
        List<FintLinks> result = FintLinks.super.getNestedResources();
        if (kontostreng != null) {
            result.add(kontostreng);
        }
        return result;
    }
    private @Valid Date anvist;
    private @Valid Date attestert;
    @NotBlank
    private String beskrivelse;
    private @Valid Identifikator kildesystemId;
    private @Valid Date kontert;
    @NotNull
    private @Valid KontostrengResource kontostreng;
    private @Valid Periode opptjent;
    @NotNull
    private @Valid Periode periode;
    private @Valid Identifikator systemId;
    @JsonIgnore
    @Override
    private Map<String, FintIdentifikator> getIdentifikators() {
        Map<String, FintIdentifikator> identifikators = new HashMap<>();
        identifikators.put("kildesystemId", this.kildesystemId);
        identifikators.put("systemId", this.systemId);

        return Collections.unmodifiableMap(identifikators);
    }

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getAnviser() {
        return getLinks().getOrDefault("anviser", Collections.emptyList()); 
    }
    public void addAnviser(Link link) {
        addLink("anviser", link);
    }
    @JsonIgnore
    public List<Link> getKonterer() {
        return getLinks().getOrDefault("konterer", Collections.emptyList()); 
    }
    public void addKonterer(Link link) {
        addLink("konterer", link);
    }
    @JsonIgnore
    public List<Link> getAttestant() {
        return getLinks().getOrDefault("attestant", Collections.emptyList()); 
    }
    public void addAttestant(Link link) {
        addLink("attestant", link);
    }
}
