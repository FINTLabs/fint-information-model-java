// Built from tag v3.5.0

package no.fint.model.utdanning.elev;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.NonNull;
import java.util.List;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Deprecated
public class Medlemskap implements FintMainObject {
    public enum Relasjonsnavn {
            MEDLEM,
            FORTLOPENDEVURDERING,
            GRUPPE,
            ENDELIGVURDERING,
            FRAVAR
    }

    @Deprecated
    @NonNull
    private Identifikator systemId;
}
