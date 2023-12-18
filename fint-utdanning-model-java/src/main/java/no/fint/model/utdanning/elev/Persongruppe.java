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
            ELEV("no.fint.model.utdanning.elev.Elev", "0..*"),
            PERSONGRUPPEMEDLEMSKAP("no.fint.model.utdanning.elev.Persongruppemedlemskap", "0..*"),
            TERMIN("no.fint.model.utdanning.elev.Termin", "0..*"),
            UNDERVISNINGSFORHOLD("no.fint.model.utdanning.elev.Undervisningsforhold", "0..*"),
            SKOLE("no.fint.model.utdanning.elev.Skole", "0..*"),
            SKOLERESSURS("no.fint.model.utdanning.elev.Skoleressurs", "0..*"),
            SKOLEAR("no.fint.model.utdanning.elev.Skolear", "0..*");
	
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
