package no.novari.fint.model.resource.administrasjon.kompleksedatatyper;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import no.novari.fint.model.resource.FintLinks;
import no.novari.fint.model.FintComplexDatatypeObject;
import no.novari.fint.model.resource.Link;
import no.novari.fint.model.FintIdentifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class KontostrengResource implements FintComplexDatatypeObject, FintLinks {

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
    public List<Link> getProsjektart() {
        return getLinks().getOrDefault("prosjektart", Collections.emptyList()); 
    }
    public void addProsjektart(Link link) {
        addLink("prosjektart", link);
    }
    @JsonIgnore
    public List<Link> getRamme() {
        return getLinks().getOrDefault("ramme", Collections.emptyList()); 
    }
    public void addRamme(Link link) {
        addLink("ramme", link);
    }
}
