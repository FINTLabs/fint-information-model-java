package no.fint.model.personvern.samtykke;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Periode;
import java.util.Date;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Samtykke implements FintMainObject {
    public enum Relasjonsnavn {
            BEHANDLING("no.fint.model.personvern.samtykke.Behandling", "1"),
            PERSON("no.fint.model.personvern.samtykke.Person", "1"),
            ORGANISASJONSELEMENT("no.fint.model.personvern.samtykke.Organisasjonselement", "0..1");
	
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

    @NotNull
    private @Valid Periode gyldighetsperiode;
    @NotNull
    private @Valid Date opprettet;
    @NotNull
    private @Valid Identifikator systemId;
}
