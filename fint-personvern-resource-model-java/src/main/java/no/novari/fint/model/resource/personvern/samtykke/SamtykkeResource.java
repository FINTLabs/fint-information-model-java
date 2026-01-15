package no.novari.fint.model.resource.personvern.samtykke;

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
import no.novari.fint.model.felles.kompleksedatatyper.Periode;
import no.novari.fint.model.resource.FintResource;
import no.novari.fint.model.resource.Link;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class SamtykkeResource implements FintResource {
  // Attributes
  @NotNull private @Valid Periode gyldighetsperiode;
  @NotNull private @Valid Date opprettet;
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
  public List<Link> getBehandling() {
    return getLinks().getOrDefault("behandling", Collections.emptyList());
  }

  public void addBehandling(Link link) {
    addLink("behandling", link);
  }

  @JsonIgnore
  public List<Link> getPerson() {
    return getLinks().getOrDefault("person", Collections.emptyList());
  }

  public void addPerson(Link link) {
    addLink("person", link);
  }

  @JsonIgnore
  public List<Link> getOrganisasjonselement() {
    return getLinks().getOrDefault("organisasjonselement", Collections.emptyList());
  }

  public void addOrganisasjonselement(Link link) {
    addLink("organisasjonselement", link);
  }
}
