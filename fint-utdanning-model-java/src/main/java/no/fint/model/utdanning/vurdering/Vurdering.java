// Built from tag v3.6.0-rc-2

package no.fint.model.utdanning.vurdering;

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
public class Vurdering implements FintMainObject {
    public enum Relasjonsnavn {
            ELEVFORHOLD,
            UNDERVISNINGSGRUPPE,
            EKSAMENSGRUPPE,
            KARAKTER
    }

    @NotNull
    private Boolean endelig;
    @NotBlank
    private String kommentar;
    @NotNull
    private @Valid Identifikator systemId;
}
