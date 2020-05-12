// Built from tag v3.5.0

package no.fint.model.administrasjon.kodeverk;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.administrasjon.kodeverk.Kontodimensjon;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Ansvar extends Kontodimensjon implements FintMainObject {
    public enum Relasjonsnavn {
            OVERORDNET,
            UNDERORDNET,
            ORGANISASJONSELEMENT,
            FULLMAKT
    }

}
