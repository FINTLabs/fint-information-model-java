package no.novari.fint.model.resource.okonomi.faktura;

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
public class FakturautstederResource implements FintResource {
  // Attributes
  @NotBlank private String navn;
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
  public List<Link> getOrganisasjonselement() {
    return getLinks().getOrDefault("organisasjonselement", Collections.emptyList());
  }

  public void addOrganisasjonselement(Link link) {
    addLink("organisasjonselement", link);
  }

  @JsonIgnore
  public List<Link> getFakturagrunnlag() {
    return getLinks().getOrDefault("fakturagrunnlag", Collections.emptyList());
  }

  public void addFakturagrunnlag(Link link) {
    addLink("fakturagrunnlag", link);
  }

  @JsonIgnore
  public List<Link> getVare() {
    return getLinks().getOrDefault("vare", Collections.emptyList());
  }

  public void addVare(Link link) {
    addLink("vare", link);
  }
}
