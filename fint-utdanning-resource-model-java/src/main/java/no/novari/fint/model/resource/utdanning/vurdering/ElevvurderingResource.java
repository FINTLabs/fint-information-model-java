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

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ElevvurderingResource implements FintResource {
    // Attributes
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
    public List<Link> getElevforhold() {
        return getLinks().getOrDefault("elevforhold", Collections.emptyList()); 
    }
    public void addElevforhold(Link link) {
        addLink("elevforhold", link);
    }
    @JsonIgnore
    public List<Link> getSluttfagvurdering() {
        return getLinks().getOrDefault("sluttfagvurdering", Collections.emptyList()); 
    }
    public void addSluttfagvurdering(Link link) {
        addLink("sluttfagvurdering", link);
    }
    @JsonIgnore
    public List<Link> getUnderveisordensvurdering() {
        return getLinks().getOrDefault("underveisordensvurdering", Collections.emptyList()); 
    }
    public void addUnderveisordensvurdering(Link link) {
        addLink("underveisordensvurdering", link);
    }
    @JsonIgnore
    public List<Link> getVitnemalsmerknad() {
        return getLinks().getOrDefault("vitnemalsmerknad", Collections.emptyList()); 
    }
    public void addVitnemalsmerknad(Link link) {
        addLink("vitnemalsmerknad", link);
    }
    @JsonIgnore
    public List<Link> getUnderveisfagvurdering() {
        return getLinks().getOrDefault("underveisfagvurdering", Collections.emptyList()); 
    }
    public void addUnderveisfagvurdering(Link link) {
        addLink("underveisfagvurdering", link);
    }
    @JsonIgnore
    public List<Link> getHalvarsordensvurdering() {
        return getLinks().getOrDefault("halvarsordensvurdering", Collections.emptyList()); 
    }
    public void addHalvarsordensvurdering(Link link) {
        addLink("halvarsordensvurdering", link);
    }
    @JsonIgnore
    public List<Link> getHalvarsfagvurdering() {
        return getLinks().getOrDefault("halvarsfagvurdering", Collections.emptyList()); 
    }
    public void addHalvarsfagvurdering(Link link) {
        addLink("halvarsfagvurdering", link);
    }
    @JsonIgnore
    public List<Link> getSluttordensvurdering() {
        return getLinks().getOrDefault("sluttordensvurdering", Collections.emptyList()); 
    }
    public void addSluttordensvurdering(Link link) {
        addLink("sluttordensvurdering", link);
    }
    @JsonIgnore
    public List<Link> getEksamensvurdering() {
        return getLinks().getOrDefault("eksamensvurdering", Collections.emptyList()); 
    }
    public void addEksamensvurdering(Link link) {
        addLink("eksamensvurdering", link);
    }
}
