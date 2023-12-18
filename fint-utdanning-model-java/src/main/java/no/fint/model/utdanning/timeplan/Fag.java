package no.fint.model.utdanning.timeplan;

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
public class Fag extends Gruppe implements FintMainObject {
    public enum Relasjonsnavn {
            PROGRAMOMRADE("no.fint.model.utdanning.timeplan.Programomrade", "0..*"),
            TILRETTELEGGING("no.fint.model.utdanning.timeplan.Elevtilrettelegging", "0..*"),
            FAGGRUPPE("no.fint.model.utdanning.timeplan.Faggruppe", "0..*"),
            SKOLE("no.fint.model.utdanning.timeplan.Skole", "0..*"),
            UNDERVISNINGSGRUPPE("no.fint.model.utdanning.timeplan.Undervisningsgruppe", "0..*"),
            EKSAMENSGRUPPE("no.fint.model.utdanning.timeplan.Eksamensgruppe", "0..*");
	
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
