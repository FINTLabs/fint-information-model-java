// Built from tag v3.6.0-rc-2

package no.fint.model.utdanning.elev;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Periode;
import no.fint.model.utdanning.basisklasser.Utdanningsforhold;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Elevforhold extends Utdanningsforhold implements FintMainObject {
    public enum Relasjonsnavn {
            ELEV,
            KATEGORI,
            SKOLE,
            BASISGRUPPE,
            BASISGRUPPEMEDLEMSKAP,
            UNDERVISNINGSGRUPPEMEDLEMSKAP,
            VURDERING,
            KONTAKTLARERGRUPPE,
            EKSAMENSGRUPPEMEDLEMSKAP,
            KONTAKTLARERGRUPPEMEDLEMSKAP,
            PROGRAMOMRADE,
            FRAVAR,
            PROGRAMOMRADEMEDLEMSKAP,
            EKSAMENSGRUPPE,
            UNDERVISNINGSGRUPPE,
            MEDLEMSKAP
    }

    private @Valid Periode gyldighetsperiode;
    private Boolean hovedskole;
}
