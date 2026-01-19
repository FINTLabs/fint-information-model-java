package no.novari.fint.model.resource.utdanning.vurdering;

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
import no.novari.fint.model.resource.FintResource;
import no.novari.fint.model.resource.Link;
import no.novari.fint.model.utdanning.basisklasser.Gruppe;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class EksamensgruppeResource extends Gruppe implements FintResource {
  // Attributes
  private @Valid Date eksamensdato;

  @JsonIgnore
  public Map<String, FintIdentifikator> getIdentifikators() {
    Map<String, FintIdentifikator> identifikators = new HashMap<>();
    identifikators.putAll(super.getIdentifikators());

    return Collections.unmodifiableMap(identifikators);
  }

  // Relations
  @Getter private final Map<String, List<Link>> links = createLinks();

  @JsonIgnore
  public List<Link> getEksamen() {
    return getLinks().getOrDefault("eksamen", Collections.emptyList());
  }

  public void addEksamen(Link link) {
    addLink("eksamen", link);
  }

  @JsonIgnore
  public List<Link> getFag() {
    return getLinks().getOrDefault("fag", Collections.emptyList());
  }

  public void addFag(Link link) {
    addLink("fag", link);
  }

  @JsonIgnore
  public List<Link> getSkole() {
    return getLinks().getOrDefault("skole", Collections.emptyList());
  }

  public void addSkole(Link link) {
    addLink("skole", link);
  }

  @JsonIgnore
  public List<Link> getTermin() {
    return getLinks().getOrDefault("termin", Collections.emptyList());
  }

  public void addTermin(Link link) {
    addLink("termin", link);
  }

  @JsonIgnore
  public List<Link> getEksamensform() {
    return getLinks().getOrDefault("eksamensform", Collections.emptyList());
  }

  public void addEksamensform(Link link) {
    addLink("eksamensform", link);
  }

  @JsonIgnore
  public List<Link> getSkolear() {
    return getLinks().getOrDefault("skolear", Collections.emptyList());
  }

  public void addSkolear(Link link) {
    addLink("skolear", link);
  }

  @JsonIgnore
  public List<Link> getUndervisningsforhold() {
    return getLinks().getOrDefault("undervisningsforhold", Collections.emptyList());
  }

  public void addUndervisningsforhold(Link link) {
    addLink("undervisningsforhold", link);
  }

  @JsonIgnore
  public List<Link> getGruppemedlemskap() {
    return getLinks().getOrDefault("gruppemedlemskap", Collections.emptyList());
  }

  public void addGruppemedlemskap(Link link) {
    addLink("gruppemedlemskap", link);
  }

  @JsonIgnore
  public List<Link> getSensor() {
    return getLinks().getOrDefault("sensor", Collections.emptyList());
  }

  public void addSensor(Link link) {
    addLink("sensor", link);
  }
}
