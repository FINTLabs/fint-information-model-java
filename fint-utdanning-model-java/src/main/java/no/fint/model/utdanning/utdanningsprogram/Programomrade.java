package no.fint.model.utdanning.utdanningsprogram;

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
public class Programomrade extends Gruppe implements FintMainObject {
    public enum Relasjonsnavn {
            ELEVFORHOLD("no.fint.model.utdanning.utdanningsprogram.Elevforhold", "0..*"),
            UTDANNINGSPROGRAM("no.fint.model.utdanning.utdanningsprogram.Utdanningsprogram", "1..*"),
            FAG("no.fint.model.utdanning.utdanningsprogram.Fag", "0..*"),
            TRINN("no.fint.model.utdanning.utdanningsprogram.Arstrinn", "0..*"),
            GRUPPEMEDLEMSKAP("no.fint.model.utdanning.utdanningsprogram.Programomrademedlemskap", "0..*");
	
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
