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
import no.fint.model.felles.kompleksedatatyper.Periode;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ArbeidsforholdResource implements FintResource, FintLinks {
    // Attributes
    @NotNull
    private Long ansettelsesprosent;
    private @Valid Periode arbeidsforholdsperiode;
    @NotNull
    private Long arslonn;
    @NotNull
    private @Valid Periode gyldighetsperiode;
    @NotNull
    private Boolean hovedstilling;
    @NotNull
    private Long lonnsprosent;
    @NotBlank
    private String stillingsnummer;
    private String stillingstittel;
    @NotNull
    private @Valid Identifikator systemId;
    @NotNull
    private Long tilstedeprosent;
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
    public List<Link> getAktivitet() {
        return getLinks().getOrDefault("aktivitet", Collections.emptyList()); 
    }
    public void addAktivitet(Link link) {
        addLink("aktivitet", link);
    }
    @JsonIgnore
    public List<Link> getAnlegg() {
        return getLinks().getOrDefault("anlegg", Collections.emptyList()); 
    }
    public void addAnlegg(Link link) {
        addLink("anlegg", link);
    }
    @JsonIgnore
    public List<Link> getAnsvar() {
        return getLinks().getOrDefault("ansvar", Collections.emptyList()); 
    }
    public void addAnsvar(Link link) {
        addLink("ansvar", link);
    }
    @JsonIgnore
    public List<Link> getArbeidsforholdstype() {
        return getLinks().getOrDefault("arbeidsforholdstype", Collections.emptyList()); 
    }
    public void addArbeidsforholdstype(Link link) {
        addLink("arbeidsforholdstype", link);
    }
    @JsonIgnore
    public List<Link> getArt() {
        return getLinks().getOrDefault("art", Collections.emptyList()); 
    }
    public void addArt(Link link) {
        addLink("art", link);
    }
    @JsonIgnore
    public List<Link> getDiverse() {
        return getLinks().getOrDefault("diverse", Collections.emptyList()); 
    }
    public void addDiverse(Link link) {
        addLink("diverse", link);
    }
    @JsonIgnore
    public List<Link> getFormal() {
        return getLinks().getOrDefault("formal", Collections.emptyList()); 
    }
    public void addFormal(Link link) {
        addLink("formal", link);
    }
    @JsonIgnore
    public List<Link> getFunksjon() {
        return getLinks().getOrDefault("funksjon", Collections.emptyList()); 
    }
    public void addFunksjon(Link link) {
        addLink("funksjon", link);
    }
    @JsonIgnore
    public List<Link> getKontrakt() {
        return getLinks().getOrDefault("kontrakt", Collections.emptyList()); 
    }
    public void addKontrakt(Link link) {
        addLink("kontrakt", link);
    }
    @JsonIgnore
    public List<Link> getLopenummer() {
        return getLinks().getOrDefault("lopenummer", Collections.emptyList()); 
    }
    public void addLopenummer(Link link) {
        addLink("lopenummer", link);
    }
    @JsonIgnore
    public List<Link> getObjekt() {
        return getLinks().getOrDefault("objekt", Collections.emptyList()); 
    }
    public void addObjekt(Link link) {
        addLink("objekt", link);
    }
    @JsonIgnore
    public List<Link> getProsjekt() {
        return getLinks().getOrDefault("prosjekt", Collections.emptyList()); 
    }
    public void addProsjekt(Link link) {
        addLink("prosjekt", link);
    }
    @JsonIgnore
    public List<Link> getRamme() {
        return getLinks().getOrDefault("ramme", Collections.emptyList()); 
    }
    public void addRamme(Link link) {
        addLink("ramme", link);
    }
    @JsonIgnore
    public List<Link> getStillingskode() {
        return getLinks().getOrDefault("stillingskode", Collections.emptyList()); 
    }
    public void addStillingskode(Link link) {
        addLink("stillingskode", link);
    }
    @JsonIgnore
    public List<Link> getTimerPerUke() {
        return getLinks().getOrDefault("timerPerUke", Collections.emptyList()); 
    }
    public void addTimerPerUke(Link link) {
        addLink("timerPerUke", link);
    }
    @JsonIgnore
    public List<Link> getArbeidslokasjon() {
        return getLinks().getOrDefault("arbeidslokasjon", Collections.emptyList()); 
    }
    public void addArbeidslokasjon(Link link) {
        addLink("arbeidslokasjon", link);
    }
    @JsonIgnore
    public List<Link> getArbeidssted() {
        return getLinks().getOrDefault("arbeidssted", Collections.emptyList()); 
    }
    public void addArbeidssted(Link link) {
        addLink("arbeidssted", link);
    }
    @JsonIgnore
    public List<Link> getPersonalleder() {
        return getLinks().getOrDefault("personalleder", Collections.emptyList()); 
    }
    public void addPersonalleder(Link link) {
        addLink("personalleder", link);
    }
    @JsonIgnore
    public List<Link> getFastlonn() {
        return getLinks().getOrDefault("fastlonn", Collections.emptyList()); 
    }
    public void addFastlonn(Link link) {
        addLink("fastlonn", link);
    }
    @JsonIgnore
    public List<Link> getFasttillegg() {
        return getLinks().getOrDefault("fasttillegg", Collections.emptyList()); 
    }
    public void addFasttillegg(Link link) {
        addLink("fasttillegg", link);
    }
    @JsonIgnore
    public List<Link> getFravar() {
        return getLinks().getOrDefault("fravar", Collections.emptyList()); 
    }
    public void addFravar(Link link) {
        addLink("fravar", link);
    }
    @Deprecated
    @JsonIgnore
    public List<Link> getLonn() {
        return getLinks().getOrDefault("lonn", Collections.emptyList()); 
    }
    @Deprecated
    public void addLonn(Link link) {
        addLink("lonn", link);
    }
    @JsonIgnore
    public List<Link> getVariabellonn() {
        return getLinks().getOrDefault("variabellonn", Collections.emptyList()); 
    }
    public void addVariabellonn(Link link) {
        addLink("variabellonn", link);
    }
    @JsonIgnore
    public List<Link> getPersonalressurs() {
        return getLinks().getOrDefault("personalressurs", Collections.emptyList()); 
    }
    public void addPersonalressurs(Link link) {
        addLink("personalressurs", link);
    }
    @JsonIgnore
    public List<Link> getUndervisningsforhold() {
        return getLinks().getOrDefault("undervisningsforhold", Collections.emptyList()); 
    }
    public void addUndervisningsforhold(Link link) {
        addLink("undervisningsforhold", link);
    }
}
