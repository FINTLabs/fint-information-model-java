// Built from tag v3.6.0-rc-1

package no.fint.model.administrasjon.personal;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.administrasjon.personal.Lonn;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Fastlonn extends Lonn implements FintMainObject {
    public enum Relasjonsnavn {
            LONNSART,
            ARBEIDSFORHOLD,
            ANVISER,
            KONTERER,
            ATTESTANT
    }

    @NotNull
    private Long prosent;
}
