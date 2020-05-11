// Built from tag v3.5.0

package no.fint.model.utdanning.vurdering;

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
public class Vurdering implements FintMainObject {
    public enum Relasjonsnavn {
            ELEVFORHOLD,
            UNDERVISNINGSGRUPPE,
            EKSAMENSGRUPPE,
            KARAKTER
    }

    @NonNull
    private Boolean endelig;
    @NonNull
    private String kommentar;
    @NonNull
    private Identifikator systemId;
}
