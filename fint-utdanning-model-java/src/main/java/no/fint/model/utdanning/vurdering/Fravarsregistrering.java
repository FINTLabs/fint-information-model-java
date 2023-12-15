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
public class Fravarsregistrering implements FintMainObject {
    public enum Relasjonsnavn {
            REGISTRERTAV,
            FAGGRUPPE,
            UNDERVISNINGSGRUPPE,
            FRAVARSTYPE,
            ELEVFRAVAR
    }

    @NotNull
    private Boolean foresPaVitnemal;
    private String kommentar;
    @NotNull
    private @Valid Periode periode;
    @NotNull
    private @Valid Identifikator systemId;
}
