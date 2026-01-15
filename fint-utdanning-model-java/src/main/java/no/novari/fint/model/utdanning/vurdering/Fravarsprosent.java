package no.novari.fint.model.utdanning.vurdering;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Fravarsprosent implements FintComplexDatatypeObject {

  public boolean isWriteable() {
    return this.writeable;
  }

  @JsonIgnore private final boolean writeable = false;
  @NotNull private Integer fravarstimer;
  @NotNull private Integer prosent;
  @NotNull private Integer undervisningstimer;
}
