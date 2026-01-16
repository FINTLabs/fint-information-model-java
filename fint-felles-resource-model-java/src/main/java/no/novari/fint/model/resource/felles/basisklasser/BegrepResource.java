package no.novari.fint.model.resource.felles.basisklasser;

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
import no.novari.fint.model.FintAbstractObject;
import no.novari.fint.model.FintIdentifikator;
import no.novari.fint.model.felles.kompleksedatatyper.Identifikator;
import no.novari.fint.model.felles.kompleksedatatyper.Periode;
import no.novari.fint.model.resource.FintLinks;
import no.novari.fint.model.resource.Link;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class BegrepResource implements FintAbstractObject, FintLinks {
  // Attributes
  private @Valid Periode gyldighetsperiode;
  @NotBlank private String kode;
  @NotBlank private String navn;
  private Boolean passiv;
  @NotNull private @Valid Identifikator systemId;

  @JsonIgnore
  public Map<String, FintIdentifikator> getIdentifikators() {
    Map<String, FintIdentifikator> identifikators = new HashMap<>();
    identifikators.put("systemId", this.systemId);

    return Collections.unmodifiableMap(identifikators);
  }

  // Relations
  @Getter private final Map<String, List<Link>> links = createLinks();
}
