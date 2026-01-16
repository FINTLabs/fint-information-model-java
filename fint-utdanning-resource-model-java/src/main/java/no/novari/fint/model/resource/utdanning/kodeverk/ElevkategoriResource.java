package no.novari.fint.model.resource.utdanning.kodeverk;

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
import no.novari.fint.model.felles.basisklasser.Begrep;
import no.novari.fint.model.resource.FintResource;
import no.novari.fint.model.resource.Link;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ElevkategoriResource extends Begrep implements FintResource {
  @JsonIgnore
  public Map<String, FintIdentifikator> getIdentifikators() {
    Map<String, FintIdentifikator> identifikators = new HashMap<>();
    identifikators.putAll(super.getIdentifikators());

    return Collections.unmodifiableMap(identifikators);
  }

  // Relations
  @Getter private final Map<String, List<Link>> links = createLinks();
}
