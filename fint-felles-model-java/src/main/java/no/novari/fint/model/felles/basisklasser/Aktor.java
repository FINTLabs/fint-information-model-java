package no.novari.fint.model.felles.basisklasser;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.validation.Valid;
import javax.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import no.novari.fint.model.FintAbstractObject;
import no.novari.fint.model.felles.kompleksedatatyper.Adresse;
import no.novari.fint.model.felles.kompleksedatatyper.Kontaktinformasjon;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class Aktor implements FintAbstractObject {

  public boolean isWriteable() {
    return this.writeable;
  }

  @JsonIgnore private final boolean writeable = true;
  private @Valid Kontaktinformasjon kontaktinformasjon;
  private @Valid Adresse postadresse;
}
