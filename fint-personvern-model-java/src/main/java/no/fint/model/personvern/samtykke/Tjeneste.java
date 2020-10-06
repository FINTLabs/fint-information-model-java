// Built from tag v3.6.0-rc-1

package no.fint.model.personvern.samtykke;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Tjeneste implements FintMainObject {
    public enum Relasjonsnavn {
            BEHANDLING
    }

    @NotBlank
    private String navn;
    @NotNull
    private @Valid Identifikator systemId;
}
