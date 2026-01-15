package no.novari.fint.model.resource.utdanning.timeplan;

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
import no.novari.fint.model.utdanning.basisklasser.Gruppe;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FagResource extends Gruppe implements FintResource {
  @JsonIgnore
  public Map<String, FintIdentifikator> getIdentifikators() {
    Map<String, FintIdentifikator> identifikators = new HashMap<>();
    identifikators.putAll(super.getIdentifikators());

    return Collections.unmodifiableMap(identifikators);
  }

  // Relations
  @Getter private final Map<String, List<Link>> links = createLinks();

  @JsonIgnore
  public List<Link> getGrepreferanse() {
    return getLinks().getOrDefault("grepreferanse", Collections.emptyList());
  }

  public void addGrepreferanse(Link link) {
    addLink("grepreferanse", link);
  }

  @JsonIgnore
  public List<Link> getProgramomrade() {
    return getLinks().getOrDefault("programomrade", Collections.emptyList());
  }

  public void addProgramomrade(Link link) {
    addLink("programomrade", link);
  }

  @JsonIgnore
  public List<Link> getVigoreferanse() {
    return getLinks().getOrDefault("vigoreferanse", Collections.emptyList());
  }

  public void addVigoreferanse(Link link) {
    addLink("vigoreferanse", link);
  }

  @JsonIgnore
  public List<Link> getTilrettelegging() {
    return getLinks().getOrDefault("tilrettelegging", Collections.emptyList());
  }

  public void addTilrettelegging(Link link) {
    addLink("tilrettelegging", link);
  }

  @JsonIgnore
  public List<Link> getFaggruppe() {
    return getLinks().getOrDefault("faggruppe", Collections.emptyList());
  }

  public void addFaggruppe(Link link) {
    addLink("faggruppe", link);
  }

  @JsonIgnore
  public List<Link> getSkole() {
    return getLinks().getOrDefault("skole", Collections.emptyList());
  }

  public void addSkole(Link link) {
    addLink("skole", link);
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
