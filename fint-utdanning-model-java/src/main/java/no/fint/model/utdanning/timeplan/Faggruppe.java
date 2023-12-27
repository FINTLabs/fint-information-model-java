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
public class Faggruppe extends Gruppe implements FintMainObject {
    public enum Relasjonsnavn {
            FAG("no.fint.model.utdanning.timeplan.Fag", "1"),
            SKOLE("no.fint.model.utdanning.utdanningsprogram.Skole", "0..1"),
            SKOLEAR("no.fint.model.utdanning.kodeverk.Skolear", "0..1"),
            FAGGRUPPEMEDLEMSKAP("no.fint.model.utdanning.timeplan.Faggruppemedlemskap", "0..*");
	
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
