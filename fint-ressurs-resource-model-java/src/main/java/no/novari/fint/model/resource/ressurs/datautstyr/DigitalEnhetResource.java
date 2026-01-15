package no.novari.fint.model.resource.ressurs.datautstyr;

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
import no.novari.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class DigitalEnhetResource implements FintResource {
    // Attributes
    private @Valid Identifikator dataobjektId;
    private Boolean flerbrukerenhet;
    private String navn;
    private Boolean privateid;
    @NotBlank
    private String serienummer;
    @NotNull
    private @Valid Identifikator systemId;
    @JsonIgnore
    public Map<String, FintIdentifikator> getIdentifikators() {
        Map<String, FintIdentifikator> identifikators = new HashMap<>();
        identifikators.put("dataobjektId", this.dataobjektId);
        identifikators.put("systemId", this.systemId);

        return Collections.unmodifiableMap(identifikators);
    }

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getAdministrator() {
        return getLinks().getOrDefault("administrator", Collections.emptyList()); 
    }
    public void addAdministrator(Link link) {
        addLink("administrator", link);
    }
    @JsonIgnore
    public List<Link> getEier() {
        return getLinks().getOrDefault("eier", Collections.emptyList()); 
    }
    public void addEier(Link link) {
        addLink("eier", link);
    }
    @JsonIgnore
    public List<Link> getPersonalressurs() {
        return getLinks().getOrDefault("personalressurs", Collections.emptyList()); 
    }
    public void addPersonalressurs(Link link) {
        addLink("personalressurs", link);
    }
    @JsonIgnore
    public List<Link> getElev() {
        return getLinks().getOrDefault("elev", Collections.emptyList()); 
    }
    public void addElev(Link link) {
        addLink("elev", link);
    }
    @JsonIgnore
    public List<Link> getStatus() {
        return getLinks().getOrDefault("status", Collections.emptyList()); 
    }
    public void addStatus(Link link) {
        addLink("status", link);
    }
    @JsonIgnore
    public List<Link> getEnhetstype() {
        return getLinks().getOrDefault("enhetstype", Collections.emptyList()); 
    }
    public void addEnhetstype(Link link) {
        addLink("enhetstype", link);
    }
    @JsonIgnore
    public List<Link> getPlattform() {
        return getLinks().getOrDefault("plattform", Collections.emptyList()); 
    }
    public void addPlattform(Link link) {
        addLink("plattform", link);
    }
    @JsonIgnore
    public List<Link> getProdusent() {
        return getLinks().getOrDefault("produsent", Collections.emptyList()); 
    }
    public void addProdusent(Link link) {
        addLink("produsent", link);
    }
    @JsonIgnore
    public List<Link> getEnhetsgruppemedlemskap() {
        return getLinks().getOrDefault("enhetsgruppemedlemskap", Collections.emptyList()); 
    }
    public void addEnhetsgruppemedlemskap(Link link) {
        addLink("enhetsgruppemedlemskap", link);
    }
}
