package no.fint.model.okonomi.regnskap;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Leverandor implements FintMainObject {
    public enum Relasjonsnavn {
            PERSON("no.fint.model.okonomi.regnskap.Person", "0..1"),
            LEVERANDORGRUPPE("no.fint.model.okonomi.regnskap.Leverandorgruppe", "0..1"),
            VIRKSOMHET("no.fint.model.okonomi.regnskap.Virksomhet", "0..1");
	
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

    private String kontonummer;
    private @Valid Identifikator leverandornummer;
    @NotNull
    private @Valid Identifikator systemId;
}
