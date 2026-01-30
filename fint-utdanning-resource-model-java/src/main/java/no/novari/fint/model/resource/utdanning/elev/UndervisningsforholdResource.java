package no.novari.fint.model.resource.utdanning.elev;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import no.novari.fint.model.FintIdentifikator;
import no.novari.fint.model.resource.FintResource;
import no.novari.fint.model.resource.Link;
import no.novari.fint.model.utdanning.basisklasser.Utdanningsforhold;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UndervisningsforholdResource extends Utdanningsforhold implements FintResource {
  // Attributes
  private Boolean hovedskole;

  @JsonIgnore
  public Map<String, FintIdentifikator> getIdentifikators() {
    Map<String, FintIdentifikator> identifikators = new HashMap<>();
    identifikators.putAll(super.getIdentifikators());

    return Collections.unmodifiableMap(identifikators);
  }

  // Relations
  @Getter private final Map<String, List<Link>> links = createLinks();

  @JsonIgnore
  public List<Link> getArbeidsforhold() {
    return getLinks().getOrDefault("arbeidsforhold", Collections.emptyList());
  }

  public void addArbeidsforhold(Link link) {
    addLink("arbeidsforhold", link);
  }

  @JsonIgnore
  public List<Link> getKlasse() {
    return getLinks().getOrDefault("klasse", Collections.emptyList());
  }

  public void addKlasse(Link link) {
    addLink("klasse", link);
  }

  @JsonIgnore
  public List<Link> getTime() {
    return getLinks().getOrDefault("time", Collections.emptyList());
  }

  public void addTime(Link link) {
    addLink("time", link);
  }

  @JsonIgnore
  public List<Link> getSkole() {
    return getLinks().getOrDefault("skole", Collections.emptyList());
  }

  public void addSkole(Link link) {
    addLink("skole", link);
  }

  @JsonIgnore
  public List<Link> getKontaktlarergruppe() {
    return getLinks().getOrDefault("kontaktlarergruppe", Collections.emptyList());
  }

  public void addKontaktlarergruppe(Link link) {
    addLink("kontaktlarergruppe", link);
  }

  @JsonIgnore
  public List<Link> getSkoleressurs() {
    return getLinks().getOrDefault("skoleressurs", Collections.emptyList());
  }

  public void addSkoleressurs(Link link) {
    addLink("skoleressurs", link);
  }

  @JsonIgnore
  public List<Link> getUndervisningsgruppe() {
    return getLinks().getOrDefault("undervisningsgruppe", Collections.emptyList());
  }

  public void addUndervisningsgruppe(Link link) {
    addLink("undervisningsgruppe", link);
  }

  @JsonIgnore
  public List<Link> getEksamensgruppe() {
    return getLinks().getOrDefault("eksamensgruppe", Collections.emptyList());
  }

  public void addEksamensgruppe(Link link) {
    addLink("eksamensgruppe", link);
  }
}
