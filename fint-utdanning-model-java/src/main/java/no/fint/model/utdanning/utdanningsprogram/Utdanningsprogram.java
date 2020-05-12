// Built from tag v3.5.0

package no.fint.model.utdanning.utdanningsprogram;

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
public class Utdanningsprogram extends Gruppe implements FintMainObject {
    public enum Relasjonsnavn {
            SKOLE,
            PROGRAMOMRADE,
            GREPREFERANSE,
            VIGOREFERANSE,
            MEDLEMSKAP
    }

}
