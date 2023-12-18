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
            ARBEIDSFORHOLD("no.fint.model.utdanning.elev.Arbeidsforhold", "1"),
            BASISGRUPPE("no.fint.model.utdanning.elev.Basisgruppe", "0..*"),
            KONTAKTLARERGRUPPE("no.fint.model.utdanning.elev.Kontaktlarergruppe", "0..*"),
            UNDERVISNINGSGRUPPE("no.fint.model.utdanning.elev.Undervisningsgruppe", "0..*"),
            EKSAMENSGRUPPE("no.fint.model.utdanning.elev.Eksamensgruppe", "0..*"),
            TIME("no.fint.model.utdanning.elev.Time", "0..*"),
            SKOLE("no.fint.model.utdanning.elev.Skole", "1"),
            SKOLERESSURS("no.fint.model.utdanning.elev.Skoleressurs", "1");
	
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

    private Boolean hovedskole;
}
