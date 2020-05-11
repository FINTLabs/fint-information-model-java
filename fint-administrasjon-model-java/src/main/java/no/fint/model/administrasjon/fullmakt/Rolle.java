// Built from tag v3.5.0

package no.fint.model.administrasjon.fullmakt;

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
public class Rolle implements FintMainObject {
    public enum Relasjonsnavn {
            FULLMAKT
    }

    @NonNull
    private String beskrivelse;
    @NonNull
    private Identifikator navn;
}
