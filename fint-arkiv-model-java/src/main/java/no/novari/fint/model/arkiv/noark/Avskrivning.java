package no.novari.fint.model.arkiv.noark;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.validation.Valid;
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
public class Avskrivning implements FintComplexDatatypeObject {

  public boolean isWriteable() {
    return this.writeable;
  }

  @JsonIgnore private final boolean writeable = true;
  @NotBlank private String avskrevetAv;
  @NotNull private @Valid Date avskrivningsdato;
  @NotBlank private String avskrivningsmate;
}
