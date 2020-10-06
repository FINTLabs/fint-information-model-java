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
import javax.validation.Valid;
import javax.validation.constraints.*;

import no.fint.model.FintMainObject;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.Link;
import no.fint.model.felles.kompleksedatatyper.Periode;
import no.fint.model.utdanning.basisklasser.Utdanningsforhold;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class ElevforholdResource extends Utdanningsforhold implements FintMainObject, FintLinks {
    // Attributes
    private @Valid Periode gyldighetsperiode;
    private Boolean hovedskole;

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getElev() {
        return getLinks().getOrDefault("elev", Collections.emptyList()); 
    }
    public void addElev(Link link) {
        addLink("elev", link);
    }
    @JsonIgnore
    public List<Link> getKategori() {
        return getLinks().getOrDefault("kategori", Collections.emptyList()); 
    }
    public void addKategori(Link link) {
        addLink("kategori", link);
    }
    @JsonIgnore
    public List<Link> getSkole() {
        return getLinks().getOrDefault("skole", Collections.emptyList()); 
    }
    public void addSkole(Link link) {
        addLink("skole", link);
    }
    @JsonIgnore
    public List<Link> getBasisgruppe() {
        return getLinks().getOrDefault("basisgruppe", Collections.emptyList()); 
    }
    public void addBasisgruppe(Link link) {
        addLink("basisgruppe", link);
    }
    @JsonIgnore
    public List<Link> getBasisgruppemedlemskap() {
        return getLinks().getOrDefault("basisgruppemedlemskap", Collections.emptyList()); 
    }
    public void addBasisgruppemedlemskap(Link link) {
        addLink("basisgruppemedlemskap", link);
    }
    @JsonIgnore
    public List<Link> getUndervisningsgruppemedlemskap() {
        return getLinks().getOrDefault("undervisningsgruppemedlemskap", Collections.emptyList()); 
    }
    public void addUndervisningsgruppemedlemskap(Link link) {
        addLink("undervisningsgruppemedlemskap", link);
    }
    @JsonIgnore
    public List<Link> getVurdering() {
        return getLinks().getOrDefault("vurdering", Collections.emptyList()); 
    }
    public void addVurdering(Link link) {
        addLink("vurdering", link);
    }
    @JsonIgnore
    public List<Link> getKontaktlarergruppe() {
        return getLinks().getOrDefault("kontaktlarergruppe", Collections.emptyList()); 
    }
    public void addKontaktlarergruppe(Link link) {
        addLink("kontaktlarergruppe", link);
    }
    @JsonIgnore
    public List<Link> getEksamensgruppemedlemskap() {
        return getLinks().getOrDefault("eksamensgruppemedlemskap", Collections.emptyList()); 
    }
    public void addEksamensgruppemedlemskap(Link link) {
        addLink("eksamensgruppemedlemskap", link);
    }
    @JsonIgnore
    public List<Link> getKontaktlarergruppemedlemskap() {
        return getLinks().getOrDefault("kontaktlarergruppemedlemskap", Collections.emptyList()); 
    }
    public void addKontaktlarergruppemedlemskap(Link link) {
        addLink("kontaktlarergruppemedlemskap", link);
    }
    @JsonIgnore
    public List<Link> getProgramomrade() {
        return getLinks().getOrDefault("programomrade", Collections.emptyList()); 
    }
    public void addProgramomrade(Link link) {
        addLink("programomrade", link);
    }
    @JsonIgnore
    public List<Link> getFravar() {
        return getLinks().getOrDefault("fravar", Collections.emptyList()); 
    }
    public void addFravar(Link link) {
        addLink("fravar", link);
    }
    @JsonIgnore
    public List<Link> getProgramomrademedlemskap() {
        return getLinks().getOrDefault("programomrademedlemskap", Collections.emptyList()); 
    }
    public void addProgramomrademedlemskap(Link link) {
        addLink("programomrademedlemskap", link);
    }
    @JsonIgnore
    public List<Link> getEksamensgruppe() {
        return getLinks().getOrDefault("eksamensgruppe", Collections.emptyList()); 
    }
    public void addEksamensgruppe(Link link) {
        addLink("eksamensgruppe", link);
    }
    @JsonIgnore
    public List<Link> getUndervisningsgruppe() {
        return getLinks().getOrDefault("undervisningsgruppe", Collections.emptyList()); 
    }
    public void addUndervisningsgruppe(Link link) {
        addLink("undervisningsgruppe", link);
    }
    @Deprecated
    @JsonIgnore
    public List<Link> getMedlemskap() {
        return getLinks().getOrDefault("medlemskap", Collections.emptyList()); 
    }
    @Deprecated
    public void addMedlemskap(Link link) {
        addLink("medlemskap", link);
    }
}
