// Built from tag v3.5.0

package no.fint.model.utdanning.elev;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.NonNull;
import java.util.List;
import no.fint.model.FintMainObject;
import no.fint.model.utdanning.basisklasser.Gruppe;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Basisgruppe extends Gruppe implements FintMainObject {
    public enum Relasjonsnavn {
            SKOLEAR,
            ELEVFORHOLD,
            TERMIN,
            TRINN,
            SKOLE,
            UNDERVISNINGSFORHOLD,
            GRUPPEMEDLEMSKAP,
            KONTAKTLARERGRUPPE,
            GREPREFERANSE,
            VIGOREFERANSE,
            MEDLEMSKAP
    }

}
