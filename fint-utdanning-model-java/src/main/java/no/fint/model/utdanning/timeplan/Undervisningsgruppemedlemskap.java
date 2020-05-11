// Built from tag v3.5.0

package no.fint.model.utdanning.timeplan;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.NonNull;
import java.util.List;
import no.fint.model.FintMainObject;
import no.fint.model.utdanning.basisklasser.Gruppemedlemskap;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Undervisningsgruppemedlemskap extends Gruppemedlemskap implements FintMainObject {
    public enum Relasjonsnavn {
            ELEVFORHOLD,
            UNDERVISNINGSGRUPPE
    }

}
