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
import java.util.HashMap;
import javax.validation.Valid;
import javax.validation.constraints.*;

import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.FintResource;
import no.fint.model.resource.Link;
import no.fint.model.FintIdentifikator;
import no.fint.model.resource.utdanning.vurdering.AnmerkningerResource;
import java.util.Date;
import no.fint.model.felles.kompleksedatatyper.Periode;
import no.fint.model.resource.utdanning.basisklasser.UtdanningsforholdResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class ElevforholdResource extends UtdanningsforholdResource implements FintResource, FintLinks {
    // Attributes
    @JsonIgnore
    @Override
    public List<FintLinks> getNestedResources() {
        List<FintLinks> result = super.getNestedResources();
        if (anmerkninger != null) {
            result.addAll(anmerkninger);
        }
        return result;
    }
    private List<@Valid AnmerkningerResource> anmerkninger;
    private Date avbruddsdato;
    private @Valid Periode gyldighetsperiode;
    private Boolean hovedskole;
    private Boolean tosprakligFagopplaring;
	@JsonIgnore
	public Map<String, FintIdentifikator> getIdentifikators() {
    	Map<String, FintIdentifikator> identifikators = new HashMap<>();
		identifikators.putAll(super.getIdentifikators());
    
    	return identifikators;
	}

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
    @Deprecated
    @JsonIgnore
    public List<Link> getSidemal() {
        return getLinks().getOrDefault("sidemal", Collections.emptyList()); 
    }
    @Deprecated
    public void addSidemal(Link link) {
        addLink("sidemal", link);
    }
    @JsonIgnore
    public List<Link> getKategori() {
        return getLinks().getOrDefault("kategori", Collections.emptyList()); 
    }
    public void addKategori(Link link) {
        addLink("kategori", link);
    }
    @Deprecated
    @JsonIgnore
    public List<Link> getKroppsoving() {
        return getLinks().getOrDefault("kroppsoving", Collections.emptyList()); 
    }
    @Deprecated
    public void addKroppsoving(Link link) {
        addLink("kroppsoving", link);
    }
    @JsonIgnore
    public List<Link> getSkole() {
        return getLinks().getOrDefault("skole", Collections.emptyList()); 
    }
    public void addSkole(Link link) {
        addLink("skole", link);
    }
    @JsonIgnore
    public List<Link> getAvbruddsarsak() {
        return getLinks().getOrDefault("avbruddsarsak", Collections.emptyList()); 
    }
    public void addAvbruddsarsak(Link link) {
        addLink("avbruddsarsak", link);
    }
    @JsonIgnore
    public List<Link> getFravarsregistreringer() {
        return getLinks().getOrDefault("fravarsregistreringer", Collections.emptyList()); 
    }
    public void addFravarsregistreringer(Link link) {
        addLink("fravarsregistreringer", link);
    }
    @JsonIgnore
    public List<Link> getFaggruppemedlemskap() {
        return getLinks().getOrDefault("faggruppemedlemskap", Collections.emptyList()); 
    }
    public void addFaggruppemedlemskap(Link link) {
        addLink("faggruppemedlemskap", link);
    }
    @JsonIgnore
    public List<Link> getSkolear() {
        return getLinks().getOrDefault("skolear", Collections.emptyList()); 
    }
    public void addSkolear(Link link) {
        addLink("skolear", link);
    }
    @Deprecated
    @JsonIgnore
    public List<Link> getBasisgruppe() {
        return getLinks().getOrDefault("basisgruppe", Collections.emptyList()); 
    }
    @Deprecated
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
    @Deprecated
    @JsonIgnore
    public List<Link> getVurdering() {
        return getLinks().getOrDefault("vurdering", Collections.emptyList()); 
    }
    @Deprecated
    public void addVurdering(Link link) {
        addLink("vurdering", link);
    }
    @JsonIgnore
    public List<Link> getSluttordensvurdering() {
        return getLinks().getOrDefault("sluttordensvurdering", Collections.emptyList()); 
    }
    public void addSluttordensvurdering(Link link) {
        addLink("sluttordensvurdering", link);
    }
    @Deprecated
    @JsonIgnore
    public List<Link> getKontaktlarergruppe() {
        return getLinks().getOrDefault("kontaktlarergruppe", Collections.emptyList()); 
    }
    @Deprecated
    public void addKontaktlarergruppe(Link link) {
        addLink("kontaktlarergruppe", link);
    }
    @JsonIgnore
    public List<Link> getUnderveisfagvurdering() {
        return getLinks().getOrDefault("underveisfagvurdering", Collections.emptyList()); 
    }
    public void addUnderveisfagvurdering(Link link) {
        addLink("underveisfagvurdering", link);
    }
    @JsonIgnore
    public List<Link> getHalvarsfagvurdering() {
        return getLinks().getOrDefault("halvarsfagvurdering", Collections.emptyList()); 
    }
    public void addHalvarsfagvurdering(Link link) {
        addLink("halvarsfagvurdering", link);
    }
    @JsonIgnore
    public List<Link> getSluttfagvurdering() {
        return getLinks().getOrDefault("sluttfagvurdering", Collections.emptyList()); 
    }
    public void addSluttfagvurdering(Link link) {
        addLink("sluttfagvurdering", link);
    }
    @JsonIgnore
    public List<Link> getPersongruppemedlemskap() {
        return getLinks().getOrDefault("persongruppemedlemskap", Collections.emptyList()); 
    }
    public void addPersongruppemedlemskap(Link link) {
        addLink("persongruppemedlemskap", link);
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
    public List<Link> getElevfravar() {
        return getLinks().getOrDefault("elevfravar", Collections.emptyList()); 
    }
    public void addElevfravar(Link link) {
        addLink("elevfravar", link);
    }
    @JsonIgnore
    public List<Link> getTilrettelegging() {
        return getLinks().getOrDefault("tilrettelegging", Collections.emptyList()); 
    }
    public void addTilrettelegging(Link link) {
        addLink("tilrettelegging", link);
    }
    @JsonIgnore
    public List<Link> getHalvarsordensvurdering() {
        return getLinks().getOrDefault("halvarsordensvurdering", Collections.emptyList()); 
    }
    public void addHalvarsordensvurdering(Link link) {
        addLink("halvarsordensvurdering", link);
    }
    @Deprecated
    @JsonIgnore
    public List<Link> getProgramomrade() {
        return getLinks().getOrDefault("programomrade", Collections.emptyList()); 
    }
    @Deprecated
    public void addProgramomrade(Link link) {
        addLink("programomrade", link);
    }
    @Deprecated
    @JsonIgnore
    public List<Link> getFravar() {
        return getLinks().getOrDefault("fravar", Collections.emptyList()); 
    }
    @Deprecated
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
    public List<Link> getUnderveisordensvurdering() {
        return getLinks().getOrDefault("underveisordensvurdering", Collections.emptyList()); 
    }
    public void addUnderveisordensvurdering(Link link) {
        addLink("underveisordensvurdering", link);
    }
    @Deprecated
    @JsonIgnore
    public List<Link> getEksamensgruppe() {
        return getLinks().getOrDefault("eksamensgruppe", Collections.emptyList()); 
    }
    @Deprecated
    public void addEksamensgruppe(Link link) {
        addLink("eksamensgruppe", link);
    }
    @Deprecated
    @JsonIgnore
    public List<Link> getUndervisningsgruppe() {
        return getLinks().getOrDefault("undervisningsgruppe", Collections.emptyList()); 
    }
    @Deprecated
    public void addUndervisningsgruppe(Link link) {
        addLink("undervisningsgruppe", link);
    }
}
