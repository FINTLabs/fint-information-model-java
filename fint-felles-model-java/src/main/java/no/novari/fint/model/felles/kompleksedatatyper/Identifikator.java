package no.novari.fint.model.felles.kompleksedatatyper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.validation.Valid;
import javax.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import no.novari.fint.model.FintComplexDatatypeObject;
import no.novari.fint.model.FintIdentifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Identifikator implements FintComplexDatatypeObject, FintIdentifikator {

  public boolean isWriteable() {
    return this.writeable;
  }

  @JsonIgnore private final boolean writeable = false;
  private @Valid Periode gyldighetsperiode;
  @NotBlank private String identifikatorverdi;
}
