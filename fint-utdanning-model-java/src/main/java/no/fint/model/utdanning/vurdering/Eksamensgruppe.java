package no.fint.model.utdanning.vurdering;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import java.util.Date;
import no.fint.model.utdanning.basisklasser.Gruppe;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Eksamensgruppe extends Gruppe implements FintMainObject {
    public enum Relasjonsnavn {
            ELEVFORHOLD,
            FAG,
            SKOLE,
            TERMIN,
            EKSAMENSFORM,
            SKOLEAR,
            UNDERVISNINGSFORHOLD,
            GRUPPEMEDLEMSKAP,
            SENSOR
    }

    private @Valid Date eksamensdato;
}
