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
            ELEVFORHOLD("no.fint.model.utdanning.vurdering.Elevforhold", "0..*"),
            EKSAMEN("no.fint.model.utdanning.vurdering.Eksamen", "0..1"),
            FAG("no.fint.model.utdanning.vurdering.Fag", "1"),
            SKOLE("no.fint.model.utdanning.vurdering.Skole", "1"),
            TERMIN("no.fint.model.utdanning.vurdering.Termin", "1"),
            EKSAMENSFORM("no.fint.model.utdanning.vurdering.Eksamensform", "0..1"),
            SKOLEAR("no.fint.model.utdanning.vurdering.Skolear", "0..1"),
            UNDERVISNINGSFORHOLD("no.fint.model.utdanning.vurdering.Undervisningsforhold", "0..*"),
            GRUPPEMEDLEMSKAP("no.fint.model.utdanning.vurdering.Eksamensgruppemedlemskap", "0..*"),
            SENSOR("no.fint.model.utdanning.vurdering.Sensor", "0..*");
	
		private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }

        public String getTypeName() {
            return typeName;
        }

        public String getMultiplicity() {
            return multiplicity;
        }
    }

    private @Valid Date eksamensdato;
}
