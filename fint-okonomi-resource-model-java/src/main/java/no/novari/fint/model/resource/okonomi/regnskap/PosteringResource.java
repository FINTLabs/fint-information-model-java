package no.novari.fint.model.resource.okonomi.regnskap;

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
import no.novari.fint.model.resource.FintLinks;
import no.novari.fint.model.resource.FintResource;
import no.novari.fint.model.resource.Link;
import no.novari.fint.model.resource.administrasjon.kompleksedatatyper.KontostrengResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PosteringResource implements FintResource {
  // Attributes
  @JsonIgnore
  @Override
  public List<FintLinks> getNestedResources() {
    List<FintLinks> result = FintResource.super.getNestedResources();
    if (kontering != null) {
      result.add(kontering);
    }
    return result;
  }

  @NotNull private Long belop;
  @NotNull private Boolean debet;
  @NotNull private @Valid KontostrengResource kontering;
  @NotNull private @Valid Identifikator posteringsId;

  @JsonIgnore
  public Map<String, FintIdentifikator> getIdentifikators() {
    Map<String, FintIdentifikator> identifikators = new HashMap<>();
    identifikators.put("posteringsId", this.posteringsId);

    return Collections.unmodifiableMap(identifikators);
  }

  // Relations
  @Getter private final Map<String, List<Link>> links = createLinks();

  @JsonIgnore
  public List<Link> getTransaksjon() {
    return getLinks().getOrDefault("transaksjon", Collections.emptyList());
  }

  public void addTransaksjon(Link link) {
    addLink("transaksjon", link);
  }
}
