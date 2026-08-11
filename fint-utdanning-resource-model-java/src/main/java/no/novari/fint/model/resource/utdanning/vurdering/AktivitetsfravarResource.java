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
import no.novari.fint.model.felles.kompleksedatatyper.Identifikator;
import no.novari.fint.model.resource.FintResource;
import no.novari.fint.model.resource.Link;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AktivitetsfravarResource implements FintResource {
  // Attributes
  @NotNull private @Valid Date dato;
  private String kommentar;
  @NotNull private Integer minutter;
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
  public List<Link> getRegistrertAv() {
    return getLinks().getOrDefault("registrertAv", Collections.emptyList());
  }

  public void addRegistrertAv(Link link) {
    addLink("registrertAv", link);
  }

  @JsonIgnore
  public List<Link> getFag() {
    return getLinks().getOrDefault("fag", Collections.emptyList());
  }

  public void addFag(Link link) {
    addLink("fag", link);
  }

  @JsonIgnore
  public List<Link> getUndervisningsgruppe() {
    return getLinks().getOrDefault("undervisningsgruppe", Collections.emptyList());
  }

  public void addUndervisningsgruppe(Link link) {
    addLink("undervisningsgruppe", link);
  }

  @JsonIgnore
  public List<Link> getFravarstype() {
    return getLinks().getOrDefault("fravarstype", Collections.emptyList());
  }

  public void addFravarstype(Link link) {
    addLink("fravarstype", link);
  }

  @JsonIgnore
  public List<Link> getElevfravar() {
    return getLinks().getOrDefault("elevfravar", Collections.emptyList());
  }

  public void addElevfravar(Link link) {
    addLink("elevfravar", link);
  }
}
