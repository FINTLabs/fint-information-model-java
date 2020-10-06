// Built from tag v3.6.0-rc-2

package no.fint.model.administrasjon.personal;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Periode;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Fravar implements FintMainObject {
    public enum Relasjonsnavn {
            FRAVARSGRUNN,
            FRAVARSTYPE,
            ARBEIDSFORHOLD,
            FORTSETTELSE,
            FORTSETTER
    }

    @NotNull
    private @Valid Periode periode;
    @NotNull
    private Long prosent;
    private @Valid Identifikator systemId;
}
