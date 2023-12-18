package no.fint.model.utdanning.larling;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Periode;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Larling implements FintMainObject {
    public enum Relasjonsnavn {
            PERSON("no.fint.model.utdanning.larling.Person", "1"),
            BEDRIFT("no.fint.model.utdanning.larling.Virksomhet", "0..1"),
            PROGRAMOMRADE("no.fint.model.utdanning.larling.Programomrade", "0..1");
	
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

    private String kontraktstype;
    private @Valid Periode laretid;
    @NotNull
    private @Valid Identifikator systemId;
}
