package no.fint.model.utdanning.elev;

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
public class Persongruppe extends Gruppe implements FintMainObject {
    public enum Relasjonsnavn {
            PERSONGRUPPEMEDLEMSKAP,
            TERMIN,
            UNDERVISNINGSFORHOLD,
            ELEV,
            SKOLE,
            SKOLERESSURS,
            SKOLEAR
    }

}
