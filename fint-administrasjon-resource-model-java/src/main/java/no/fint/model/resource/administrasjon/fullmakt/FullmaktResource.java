package no.fint.model.resource.administrasjon.fullmakt;

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
import no.fint.model.FintResourceObject;
import no.fint.model.resource.Link;
import no.fint.model.FintIdentifikator;
import no.fint.model.felles.kompleksedatatyper.Periode;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class FullmaktResource implements FintResourceObject, FintLinks {
    // Attributes
    @NotNull
    private @Valid Periode gyldighetsperiode;
    @NotNull
    private @Valid Identifikator systemId;
    @JsonIgnore
    public Map<String, FintIdentifikator> getIdentifikators() {
        Map<String, FintIdentifikator> identifikators = new HashMap<>();
        identifikators.put("systemId", this.systemId);
    
        return identifikators;
    }

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @Deprecated
    @JsonIgnore
    public List<Link> getMyndighet() {
        return getLinks().getOrDefault("myndighet", Collections.emptyList()); 
    }
    @Deprecated
    public void addMyndighet(Link link) {
        addLink("myndighet", link);
    }
    @JsonIgnore
    public List<Link> getRamme() {
        return getLinks().getOrDefault("ramme", Collections.emptyList()); 
    }
    public void addRamme(Link link) {
        addLink("ramme", link);
    }
    @JsonIgnore
    public List<Link> getFunksjon() {
        return getLinks().getOrDefault("funksjon", Collections.emptyList()); 
    }
    public void addFunksjon(Link link) {
        addLink("funksjon", link);
    }
    @JsonIgnore
    public List<Link> getObjekt() {
        return getLinks().getOrDefault("objekt", Collections.emptyList()); 
    }
    public void addObjekt(Link link) {
        addLink("objekt", link);
    }
    @JsonIgnore
    public List<Link> getOrganisasjonselement() {
        return getLinks().getOrDefault("organisasjonselement", Collections.emptyList()); 
    }
    public void addOrganisasjonselement(Link link) {
        addLink("organisasjonselement", link);
    }
    @JsonIgnore
    public List<Link> getArt() {
        return getLinks().getOrDefault("art", Collections.emptyList()); 
    }
    public void addArt(Link link) {
        addLink("art", link);
    }
    @JsonIgnore
    public List<Link> getAnlegg() {
        return getLinks().getOrDefault("anlegg", Collections.emptyList()); 
    }
    public void addAnlegg(Link link) {
        addLink("anlegg", link);
    }
    @JsonIgnore
    public List<Link> getDiverse() {
        return getLinks().getOrDefault("diverse", Collections.emptyList()); 
    }
    public void addDiverse(Link link) {
        addLink("diverse", link);
    }
    @JsonIgnore
    public List<Link> getAktivitet() {
        return getLinks().getOrDefault("aktivitet", Collections.emptyList()); 
    }
    public void addAktivitet(Link link) {
        addLink("aktivitet", link);
    }
    @JsonIgnore
    public List<Link> getAnsvar() {
        return getLinks().getOrDefault("ansvar", Collections.emptyList()); 
    }
    public void addAnsvar(Link link) {
        addLink("ansvar", link);
    }
    @JsonIgnore
    public List<Link> getStedfortreder() {
        return getLinks().getOrDefault("stedfortreder", Collections.emptyList()); 
    }
    public void addStedfortreder(Link link) {
        addLink("stedfortreder", link);
    }
    @JsonIgnore
    public List<Link> getKontrakt() {
        return getLinks().getOrDefault("kontrakt", Collections.emptyList()); 
    }
    public void addKontrakt(Link link) {
        addLink("kontrakt", link);
    }
    @JsonIgnore
    public List<Link> getFullmektig() {
        return getLinks().getOrDefault("fullmektig", Collections.emptyList()); 
    }
    public void addFullmektig(Link link) {
        addLink("fullmektig", link);
    }
    @JsonIgnore
    public List<Link> getProsjekt() {
        return getLinks().getOrDefault("prosjekt", Collections.emptyList()); 
    }
    public void addProsjekt(Link link) {
        addLink("prosjekt", link);
    }
    @JsonIgnore
    public List<Link> getFormal() {
        return getLinks().getOrDefault("formal", Collections.emptyList()); 
    }
    public void addFormal(Link link) {
        addLink("formal", link);
    }
    @JsonIgnore
    public List<Link> getRolle() {
        return getLinks().getOrDefault("rolle", Collections.emptyList()); 
    }
    public void addRolle(Link link) {
        addLink("rolle", link);
    }
    @JsonIgnore
    public List<Link> getLopenummer() {
        return getLinks().getOrDefault("lopenummer", Collections.emptyList()); 
    }
    public void addLopenummer(Link link) {
        addLink("lopenummer", link);
    }
}
