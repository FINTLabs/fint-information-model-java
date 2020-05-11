// Built from tag v3.5.0

package no.fint.model.administrasjon.personal;

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
            FRAVARSGRUNN,
            FRAVARSTYPE,
            ARBEIDSFORHOLD,
            FORTSETTELSE,
            FORTSETTER
    }

    @NonNull
    private Periode periode;
    @NonNull
    private Long prosent;
    private Identifikator systemId;
}
