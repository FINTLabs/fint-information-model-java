package no.novari.fint.model.resource.ressurs.datautstyr;

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
public class EnhetsgruppemedlemskapResource implements FintResource {
  // Attributes
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
  public List<Link> getDigitalEnhet() {
    return getLinks().getOrDefault("digitalEnhet", Collections.emptyList());
  }

  public void addDigitalEnhet(Link link) {
    addLink("digitalEnhet", link);
  }

  @JsonIgnore
  public List<Link> getEnhetsgruppe() {
    return getLinks().getOrDefault("enhetsgruppe", Collections.emptyList());
  }

  public void addEnhetsgruppe(Link link) {
    addLink("enhetsgruppe", link);
  }
}
