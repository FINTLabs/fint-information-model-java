package no.novari.fint.model.resource.arkiv.kulturminnevern;

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
import no.novari.fint.model.resource.arkiv.noark.SaksmappeResource;
import no.novari.fint.model.resource.felles.kompleksedatatyper.MatrikkelnummerResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DispensasjonAutomatiskFredaKulturminneResource extends SaksmappeResource
    implements FintResource {
  // Attributes
  @JsonIgnore
  @Override
  public List<FintLinks> getNestedResources() {
    List<FintLinks> result = super.getNestedResources();
    if (matrikkelnummer != null) {
      result.add(matrikkelnummer);
    }
    return result;
  }

  @NotBlank private String kulturminneId;
  @NotNull private @Valid MatrikkelnummerResource matrikkelnummer;
  @NotNull private @Valid Identifikator soknadsnummer;
  private String tiltak;

  @JsonIgnore
  public Map<String, FintIdentifikator> getIdentifikators() {
    Map<String, FintIdentifikator> identifikators = new HashMap<>();
    identifikators.putAll(super.getIdentifikators());
    identifikators.put("soknadsnummer", this.soknadsnummer);

    return Collections.unmodifiableMap(identifikators);
  }

  // Relations
  @Getter private final Map<String, List<Link>> links = createLinks();
}
