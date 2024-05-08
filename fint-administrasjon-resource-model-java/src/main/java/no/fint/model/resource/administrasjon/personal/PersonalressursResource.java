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
import no.fint.model.resource.FintResource;
import no.fint.model.resource.Link;
import no.fint.model.FintIdentifikator;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.felles.kompleksedatatyper.Periode;
import java.util.Date;
import no.fint.model.felles.kompleksedatatyper.Kontaktinformasjon;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PersonalressursResource implements resource.FintResource, FintLinks {
    // Attributes
    @NotNull
    private @Valid Identifikator ansattnummer;
    @NotNull
    private @Valid Periode ansettelsesperiode;
    private Date ansiennitet;
    private @Valid Identifikator brukernavn;
    private String jobbtittel;
    private @Valid Kontaktinformasjon kontaktinformasjon;
    private @Valid Identifikator systemId;
    @JsonIgnore
    public Map<String, FintIdentifikator> getIdentifikators() {
        Map<String, FintIdentifikator> identifikators = new HashMap<>();
        identifikators.put("ansattnummer", this.ansattnummer);
        identifikators.put("brukernavn", this.brukernavn);
        identifikators.put("systemId", this.systemId);
    
        return identifikators;
    }

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getPersonalressurskategori() {
        return getLinks().getOrDefault("personalressurskategori", Collections.emptyList()); 
    }
    public void addPersonalressurskategori(Link link) {
        addLink("personalressurskategori", link);
    }
    @JsonIgnore
    public List<Link> getArbeidsforhold() {
        return getLinks().getOrDefault("arbeidsforhold", Collections.emptyList()); 
    }
    public void addArbeidsforhold(Link link) {
        addLink("arbeidsforhold", link);
    }
    @JsonIgnore
    public List<Link> getPerson() {
        return getLinks().getOrDefault("person", Collections.emptyList()); 
    }
    public void addPerson(Link link) {
        addLink("person", link);
    }
    @JsonIgnore
    public List<Link> getStedfortreder() {
        return getLinks().getOrDefault("stedfortreder", Collections.emptyList()); 
    }
    public void addStedfortreder(Link link) {
        addLink("stedfortreder", link);
    }
    @JsonIgnore
    public List<Link> getFullmakt() {
        return getLinks().getOrDefault("fullmakt", Collections.emptyList()); 
    }
    public void addFullmakt(Link link) {
        addLink("fullmakt", link);
    }
    @JsonIgnore
    public List<Link> getLeder() {
        return getLinks().getOrDefault("leder", Collections.emptyList()); 
    }
    public void addLeder(Link link) {
        addLink("leder", link);
    }
    @JsonIgnore
    public List<Link> getPersonalansvar() {
        return getLinks().getOrDefault("personalansvar", Collections.emptyList()); 
    }
    public void addPersonalansvar(Link link) {
        addLink("personalansvar", link);
    }
    @JsonIgnore
    public List<Link> getSkoleressurs() {
        return getLinks().getOrDefault("skoleressurs", Collections.emptyList()); 
    }
    public void addSkoleressurs(Link link) {
        addLink("skoleressurs", link);
    }
}
