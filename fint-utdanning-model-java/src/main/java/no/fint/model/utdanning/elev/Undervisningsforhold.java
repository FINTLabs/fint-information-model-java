package no.fint.model.utdanning.elev;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.utdanning.basisklasser.Utdanningsforhold;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Undervisningsforhold extends Utdanningsforhold implements FintMainObject {
    public enum Relasjonsnavn {
            ARBEIDSFORHOLD,
            BASISGRUPPE,
            KONTAKTLARERGRUPPE,
            UNDERVISNINGSGRUPPE,
            EKSAMENSGRUPPE,
            TIME,
            SKOLE,
            SKOLERESSURS
    }

    private Boolean hovedskole;
}
