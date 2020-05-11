// Built from tag v3.5.0

package no.fint.model.utdanning.vurdering;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.NonNull;
import java.util.List;
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
            UNDERVISNINGSGRUPPE,
            EKSAMENSGRUPPE,
            FRAVARSTYPE
    }

    @NonNull
    private Boolean dokumentert;
    @NonNull
    private Boolean foresPaVitnemal;
    @NonNull
    private Periode gjelderPeriode;
    @NonNull
    private String kommentar;
    @NonNull
    private Identifikator systemId;
}
