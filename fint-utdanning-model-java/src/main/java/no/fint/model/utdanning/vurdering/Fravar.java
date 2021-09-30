package no.fint.model.utdanning.vurdering;

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
            ELEVFORHOLD,
            REGISTRERTAV,
            UNDERVISNINGSGRUPPE,
            EKSAMENSGRUPPE,
            FRAVARSTYPE
    }

    @Deprecated
    @NotNull
    private Boolean dokumentert;
    @NotNull
    private Boolean foresPaVitnemal;
    @NotNull
    private @Valid Periode gjelderPeriode;
    @NotBlank
    private String kommentar;
    @NotNull
    private @Valid Identifikator systemId;
}
