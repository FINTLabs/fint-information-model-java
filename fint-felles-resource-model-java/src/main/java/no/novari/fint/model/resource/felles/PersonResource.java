package no.novari.fint.model.resource.felles;

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

import no.novari.fint.model.resource.FintLinks;
import no.novari.fint.model.resource.FintResource;
import no.novari.fint.model.resource.Link;
import no.novari.fint.model.FintIdentifikator;
import no.novari.fint.model.resource.felles.kompleksedatatyper.AdresseResource;
import java.util.Date;
import no.novari.fint.model.felles.kompleksedatatyper.Identifikator;
import no.novari.fint.model.felles.kompleksedatatyper.Personnavn;
import no.novari.fint.model.resource.felles.basisklasser.AktorResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class PersonResource extends AktorResource implements FintResource {
    // Attributes
    @JsonIgnore
    @Override
    public List<FintLinks> getNestedResources() {
        List<FintLinks> result = super.getNestedResources();
        if (bostedsadresse != null) {
            result.add(bostedsadresse);
        }
        return result;
    }
    private String bilde;
    private @Valid AdresseResource bostedsadresse;
    private Date fodselsdato;
    @NotNull
    private @Valid Identifikator fodselsnummer;
    @NotNull
    private @Valid Personnavn navn;
    @JsonIgnore
    public Map<String, FintIdentifikator> getIdentifikators() {
        Map<String, FintIdentifikator> identifikators = new HashMap<>();
        identifikators.put("fodselsnummer", this.fodselsnummer);

        return Collections.unmodifiableMap(identifikators);
    }

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getStatsborgerskap() {
        return getLinks().getOrDefault("statsborgerskap", Collections.emptyList()); 
    }
    public void addStatsborgerskap(Link link) {
        addLink("statsborgerskap", link);
    }
    @JsonIgnore
    public List<Link> getKommune() {
        return getLinks().getOrDefault("kommune", Collections.emptyList()); 
    }
    public void addKommune(Link link) {
        addLink("kommune", link);
    }
    @JsonIgnore
    public List<Link> getKjonn() {
        return getLinks().getOrDefault("kjonn", Collections.emptyList()); 
    }
    public void addKjonn(Link link) {
        addLink("kjonn", link);
    }
    @JsonIgnore
    public List<Link> getForeldreansvar() {
        return getLinks().getOrDefault("foreldreansvar", Collections.emptyList()); 
    }
    public void addForeldreansvar(Link link) {
        addLink("foreldreansvar", link);
    }
    @JsonIgnore
    public List<Link> getMalform() {
        return getLinks().getOrDefault("malform", Collections.emptyList()); 
    }
    public void addMalform(Link link) {
        addLink("malform", link);
    }
    @JsonIgnore
    public List<Link> getPersonalressurs() {
        return getLinks().getOrDefault("personalressurs", Collections.emptyList()); 
    }
    public void addPersonalressurs(Link link) {
        addLink("personalressurs", link);
    }
    @JsonIgnore
    public List<Link> getMorsmal() {
        return getLinks().getOrDefault("morsmal", Collections.emptyList()); 
    }
    public void addMorsmal(Link link) {
        addLink("morsmal", link);
    }
    @JsonIgnore
    public List<Link> getParorende() {
        return getLinks().getOrDefault("parorende", Collections.emptyList()); 
    }
    public void addParorende(Link link) {
        addLink("parorende", link);
    }
    @JsonIgnore
    public List<Link> getForeldre() {
        return getLinks().getOrDefault("foreldre", Collections.emptyList()); 
    }
    public void addForeldre(Link link) {
        addLink("foreldre", link);
    }
    @JsonIgnore
    public List<Link> getLarling() {
        return getLinks().getOrDefault("larling", Collections.emptyList()); 
    }
    public void addLarling(Link link) {
        addLink("larling", link);
    }
    @JsonIgnore
    public List<Link> getElev() {
        return getLinks().getOrDefault("elev", Collections.emptyList()); 
    }
    public void addElev(Link link) {
        addLink("elev", link);
    }
    @JsonIgnore
    public List<Link> getOtungdom() {
        return getLinks().getOrDefault("otungdom", Collections.emptyList()); 
    }
    public void addOtungdom(Link link) {
        addLink("otungdom", link);
    }
}
