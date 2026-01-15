package no.novari.fint.model.utdanning.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import no.novari.fint.model.FintReference;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Vigoreferanse implements FintReference {

  public boolean isWriteable() {
    return this.writeable;
  }

  @JsonIgnore private final boolean writeable = false;
}
