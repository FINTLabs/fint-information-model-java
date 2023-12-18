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
public class Kontaktlarergruppe extends Gruppe implements FintMainObject {
    public enum Relasjonsnavn {
            BASISGRUPPE("no.fint.model.utdanning.elev.Basisgruppe", "1..*"),
            ELEVFORHOLD("no.fint.model.utdanning.elev.Elevforhold", "0..*"),
            TERMIN("no.fint.model.utdanning.elev.Termin", "0..*"),
            SKOLE("no.fint.model.utdanning.elev.Skole", "1"),
            SKOLEAR("no.fint.model.utdanning.elev.Skolear", "0..1"),
            UNDERVISNINGSFORHOLD("no.fint.model.utdanning.elev.Undervisningsforhold", "0..*"),
            GRUPPEMEDLEMSKAP("no.fint.model.utdanning.elev.Kontaktlarergruppemedlemskap", "0..*");
	
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

}
