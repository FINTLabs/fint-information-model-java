package no.novari.fint.model.resource.utdanning.larling;

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
import no.novari.fint.model.felles.kompleksedatatyper.Identifikator;
import no.novari.fint.model.resource.FintResource;
import no.novari.fint.model.resource.Link;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AvlagtProveResource implements FintResource {
  // Attributes
  private Date provedato;
  @NotNull private @Valid Identifikator systemId;

  @JsonIgnore
  public Map<String, FintIdentifikator> getIdentifikators() {
    Map<String, FintIdentifikator> identifikators = new HashMap<>();
    identifikators.put("systemId", this.systemId);

    return Collections.unmodifiableMap(identifikators);
  }

  // Relations
  @Getter private final Map<String, List<Link>> links = createLinks();

  @JsonIgnore
  public List<Link> getProvestatus() {
    return getLinks().getOrDefault("provestatus", Collections.emptyList());
  }

  public void addProvestatus(Link link) {
    addLink("provestatus", link);
  }

  @JsonIgnore
  public List<Link> getLarling() {
    return getLinks().getOrDefault("larling", Collections.emptyList());
  }

  public void addLarling(Link link) {
    addLink("larling", link);
  }

  @JsonIgnore
  public List<Link> getFullfortkode() {
    return getLinks().getOrDefault("fullfortkode", Collections.emptyList());
  }

  public void addFullfortkode(Link link) {
    addLink("fullfortkode", link);
  }

  @JsonIgnore
  public List<Link> getBrevtype() {
    return getLinks().getOrDefault("brevtype", Collections.emptyList());
  }

  public void addBrevtype(Link link) {
    addLink("brevtype", link);
  }

  @JsonIgnore
  public List<Link> getBevistype() {
    return getLinks().getOrDefault("bevistype", Collections.emptyList());
  }

  public void addBevistype(Link link) {
    addLink("bevistype", link);
  }
}
