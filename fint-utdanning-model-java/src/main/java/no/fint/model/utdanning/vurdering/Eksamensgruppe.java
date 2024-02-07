package no.fint.model.utdanning.vurdering;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
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
    @Getter
    public enum Relasjonsnavn {
            ELEVFORHOLD("no.fint.model.utdanning.elev.Elevforhold", "0..*"),
            EKSAMEN("no.fint.model.utdanning.timeplan.Eksamen", "0..1"),
            FAG("no.fint.model.utdanning.timeplan.Fag", "1"),
            SKOLE("no.fint.model.utdanning.utdanningsprogram.Skole", "1"),
            TERMIN("no.fint.model.utdanning.kodeverk.Termin", "1"),
            EKSAMENSFORM("no.fint.model.utdanning.kodeverk.Eksamensform", "0..1"),
            SKOLEAR("no.fint.model.utdanning.kodeverk.Skolear", "0..1"),
            UNDERVISNINGSFORHOLD("no.fint.model.utdanning.elev.Undervisningsforhold", "0..*"),
            GRUPPEMEDLEMSKAP("no.fint.model.utdanning.vurdering.Eksamensgruppemedlemskap", "0..*"),
            SENSOR("no.fint.model.utdanning.vurdering.Sensor", "0..*");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }
    }

    private @Valid Date eksamensdato;
}
