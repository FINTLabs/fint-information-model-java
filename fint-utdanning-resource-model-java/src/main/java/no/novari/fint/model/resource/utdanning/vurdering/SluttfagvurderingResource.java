package no.novari.fint.model.resource.utdanning.vurdering;

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

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SluttfagvurderingResource extends FagvurderingResource implements FintResource {
  @JsonIgnore
  public Map<String, FintIdentifikator> getIdentifikators() {
    Map<String, FintIdentifikator> identifikators = new HashMap<>();
    identifikators.putAll(super.getIdentifikators());

    return Collections.unmodifiableMap(identifikators);
  }

  // Relations
  @Getter private final Map<String, List<Link>> links = createLinks();

  @Deprecated
  @JsonIgnore
  public List<Link> getEksamensgruppe() {
    return getLinks().getOrDefault("eksamensgruppe", Collections.emptyList());
  }

  @Deprecated
  public void addEksamensgruppe(Link link) {
    addLink("eksamensgruppe", link);
  }

  @JsonIgnore
  public List<Link> getKarakterhistorie() {
    return getLinks().getOrDefault("karakterhistorie", Collections.emptyList());
  }

  public void addKarakterhistorie(Link link) {
    addLink("karakterhistorie", link);
  }

  @JsonIgnore
  public List<Link> getElevvurdering() {
    return getLinks().getOrDefault("elevvurdering", Collections.emptyList());
  }

  public void addElevvurdering(Link link) {
    addLink("elevvurdering", link);
  }
}
