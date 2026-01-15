package no.novari.fint.model.okonomi.regnskap;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import no.novari.fint.model.FintComplexDatatypeObject;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Bilag implements FintComplexDatatypeObject {

  public boolean isWriteable() {
    return this.writeable;
  }

  @JsonIgnore private final boolean writeable = true;
  @NotNull private Date bilagsdato;
  private String bilagsnummer;
  private String data;
  private String filnavn;
  private String referanse;
  private String url;
}
