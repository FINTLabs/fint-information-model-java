package no.novari.fint.model.resource.utdanning.elev;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import no.novari.fint.model.FintIdentifikator;
import no.novari.fint.model.felles.kompleksedatatyper.Periode;
import no.novari.fint.model.resource.FintLinks;
import no.novari.fint.model.resource.FintResource;
import no.novari.fint.model.resource.Link;
import no.novari.fint.model.resource.utdanning.vurdering.AnmerkningerResource;
import no.novari.fint.model.utdanning.basisklasser.Utdanningsforhold;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ElevforholdResource extends Utdanningsforhold implements FintResource {
  // Attributes
  @JsonIgnore
  @Override
  public List<FintLinks> getNestedResources() {
    List<FintLinks> result = FintResource.super.getNestedResources();
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

    return Collections.unmodifiableMap(identifikators);
  }

  // Relations
  @Getter private final Map<String, List<Link>> links = createLinks();

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

  @JsonIgnore
  public List<Link> getUndervisningsgruppemedlemskap() {
    return getLinks().getOrDefault("undervisningsgruppemedlemskap", Collections.emptyList());
  }

  public void addUndervisningsgruppemedlemskap(Link link) {
    addLink("undervisningsgruppemedlemskap", link);
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
  public List<Link> getElevvurdering() {
    return getLinks().getOrDefault("elevvurdering", Collections.emptyList());
  }

  public void addElevvurdering(Link link) {
    addLink("elevvurdering", link);
  }

  @JsonIgnore
  public List<Link> getProgramomrademedlemskap() {
    return getLinks().getOrDefault("programomrademedlemskap", Collections.emptyList());
  }

  public void addProgramomrademedlemskap(Link link) {
    addLink("programomrademedlemskap", link);
  }

  @JsonIgnore
  public List<Link> getKlassemedlemskap() {
    return getLinks().getOrDefault("klassemedlemskap", Collections.emptyList());
  }

  public void addKlassemedlemskap(Link link) {
    addLink("klassemedlemskap", link);
  }
}
