// Built from tag v3.6.0-rc-1

package no.fint.model.utdanning.timeplan;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.utdanning.basisklasser.Gruppe;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Undervisningsgruppe extends Gruppe implements FintMainObject {
    public enum Relasjonsnavn {
            ELEVFORHOLD,
            FAG,
            TERMIN,
            SKOLE,
            SKOLEAR,
            UNDERVISNINGSFORHOLD,
            TIME,
            GRUPPEMEDLEMSKAP,
            GREPREFERANSE,
            VIGOREFERANSE,
            MEDLEMSKAP
    }

}
