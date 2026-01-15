package no.novari.fint.model.resource.arkiv.noark;

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
import no.novari.fint.model.FintAbstractObject;
import no.novari.fint.model.resource.Link;
import no.novari.fint.model.FintIdentifikator;
import java.util.Date;
import no.novari.fint.model.resource.arkiv.noark.DokumentbeskrivelseResource;
import no.novari.fint.model.resource.arkiv.noark.KlasseResource;
import no.novari.fint.model.resource.arkiv.noark.KorrespondansepartResource;
import no.novari.fint.model.resource.arkiv.noark.MerknadResource;
import no.novari.fint.model.resource.arkiv.noark.PartResource;
import no.novari.fint.model.resource.arkiv.noark.SkjermingResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class RegistreringResource implements FintAbstractObject, FintLinks {
    // Attributes
    @JsonIgnore
    @Override
    public List<FintLinks> getNestedResources() {
        List<FintLinks> result = FintLinks.super.getNestedResources();
        if (dokumentbeskrivelse != null) {
            result.addAll(dokumentbeskrivelse);
        }
        if (klasse != null) {
            result.add(klasse);
        }
        if (korrespondansepart != null) {
            result.addAll(korrespondansepart);
        }
        if (merknad != null) {
            result.addAll(merknad);
        }
        if (part != null) {
            result.addAll(part);
        }
        if (skjerming != null) {
            result.add(skjerming);
        }
        return result;
    }
    private @Valid Date arkivertDato;
    private String beskrivelse;
    private List<@Valid DokumentbeskrivelseResource> dokumentbeskrivelse;
    private List<String> forfatter;
    private @Valid KlasseResource klasse;
    private List<@Valid KorrespondansepartResource> korrespondansepart;
    private List<@Valid MerknadResource> merknad;
    private List<String> nokkelord;
    private String offentligTittel;
    private @Valid Date opprettetDato;
    private List<@Valid PartResource> part;
    private List<String> referanseArkivDel;
    private String registreringsId;
    private @Valid SkjermingResource skjerming;
    @NotBlank
    private String tittel;

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getTilgangsgruppe() {
        return getLinks().getOrDefault("tilgangsgruppe", Collections.emptyList()); 
    }
    public void addTilgangsgruppe(Link link) {
        addLink("tilgangsgruppe", link);
    }
    @JsonIgnore
    public List<Link> getAdministrativEnhet() {
        return getLinks().getOrDefault("administrativEnhet", Collections.emptyList()); 
    }
    public void addAdministrativEnhet(Link link) {
        addLink("administrativEnhet", link);
    }
    @JsonIgnore
    public List<Link> getArkivdel() {
        return getLinks().getOrDefault("arkivdel", Collections.emptyList()); 
    }
    public void addArkivdel(Link link) {
        addLink("arkivdel", link);
    }
    @JsonIgnore
    public List<Link> getSaksbehandler() {
        return getLinks().getOrDefault("saksbehandler", Collections.emptyList()); 
    }
    public void addSaksbehandler(Link link) {
        addLink("saksbehandler", link);
    }
    @JsonIgnore
    public List<Link> getArkivertAv() {
        return getLinks().getOrDefault("arkivertAv", Collections.emptyList()); 
    }
    public void addArkivertAv(Link link) {
        addLink("arkivertAv", link);
    }
    @JsonIgnore
    public List<Link> getOpprettetAv() {
        return getLinks().getOrDefault("opprettetAv", Collections.emptyList()); 
    }
    public void addOpprettetAv(Link link) {
        addLink("opprettetAv", link);
    }
}
