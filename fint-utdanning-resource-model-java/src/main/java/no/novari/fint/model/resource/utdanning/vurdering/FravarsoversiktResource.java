package no.novari.fint.model.resource.utdanning.vurdering;

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
import no.novari.fint.model.utdanning.vurdering.Fravarsprosent;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class FravarsoversiktResource implements FintResource {
  // Attributes
  @NotNull private @Valid Fravarsprosent halvar;
  @NotNull private @Valid Fravarsprosent skolear;
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
  public List<Link> getElevforhold() {
    return getLinks().getOrDefault("elevforhold", Collections.emptyList());
  }

  public void addElevforhold(Link link) {
    addLink("elevforhold", link);
  }

  @JsonIgnore
  public List<Link> getFag() {
    return getLinks().getOrDefault("fag", Collections.emptyList());
  }

  public void addFag(Link link) {
    addLink("fag", link);
  }
}
