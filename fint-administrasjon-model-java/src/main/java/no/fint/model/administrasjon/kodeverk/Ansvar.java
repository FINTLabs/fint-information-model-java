package no.fint.model.administrasjon.kodeverk;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.administrasjon.kodeverk.Kontodimensjon;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Ansvar extends Kontodimensjon implements FintMainObject {
    public enum Relasjonsnavn {
            OVERORDNET("no.fint.model.administrasjon.kodeverk.Ansvar", "0..1"),
            UNDERORDNET("no.fint.model.administrasjon.kodeverk.Ansvar", "0..*"),
            ORGANISASJONSELEMENT("no.fint.model.administrasjon.kodeverk.Organisasjonselement", "0..*");
	
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
