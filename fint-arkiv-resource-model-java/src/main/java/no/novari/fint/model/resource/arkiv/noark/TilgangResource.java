package no.novari.fint.model.resource.arkiv.noark;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collections;
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
public class TilgangResource implements FintResource {
  // Attributes
  @NotNull private @Valid Identifikator systemId;
  @NotBlank private String tittel;

  @JsonIgnore
  public Map<String, FintIdentifikator> getIdentifikators() {
    Map<String, FintIdentifikator> identifikators = new HashMap<>();
    identifikators.put("systemId", this.systemId);

    return Collections.unmodifiableMap(identifikators);
  }

  // Relations
  @Getter private final Map<String, List<Link>> links = createLinks();

  @JsonIgnore
  public List<Link> getRolle() {
    return getLinks().getOrDefault("rolle", Collections.emptyList());
  }

  public void addRolle(Link link) {
    addLink("rolle", link);
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
  public List<Link> getArkivressurs() {
    return getLinks().getOrDefault("arkivressurs", Collections.emptyList());
  }

  public void addArkivressurs(Link link) {
    addLink("arkivressurs", link);
  }
}
