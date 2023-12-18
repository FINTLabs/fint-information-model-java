package no.fint.model.utdanning.utdanningsprogram;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.felles.basisklasser.Enhet;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Skole extends Enhet implements FintMainObject {
    public enum Relasjonsnavn {
            ORGANISASJON("no.fint.model.utdanning.utdanningsprogram.Organisasjonselement", "0..1"),
            FAG("no.fint.model.utdanning.utdanningsprogram.Fag", "0..*"),
            SKOLEEIERTYPE("no.fint.model.utdanning.utdanningsprogram.Skoleeiertype", "0..1"),
            VIGOREFERANSE("no.fint.model.utdanning.utdanningsprogram.Vigoreferanse", "0..1"),
            BASISGRUPPE("no.fint.model.utdanning.utdanningsprogram.Basisgruppe", "0..*"),
            ELEVFORHOLD("no.fint.model.utdanning.utdanningsprogram.Elevforhold", "0..*"),
            KONTAKTLARERGRUPPE("no.fint.model.utdanning.utdanningsprogram.Kontaktlarergruppe", "0..*"),
            SKOLERESSURS("no.fint.model.utdanning.utdanningsprogram.Skoleressurs", "0..*"),
            UNDERVISNINGSFORHOLD("no.fint.model.utdanning.utdanningsprogram.Undervisningsforhold", "0..*"),
            FAGGRUPPE("no.fint.model.utdanning.utdanningsprogram.Faggruppe", "0..*"),
            UNDERVISNINGSGRUPPE("no.fint.model.utdanning.utdanningsprogram.Undervisningsgruppe", "0..*"),
            EKSAMENSGRUPPE("no.fint.model.utdanning.utdanningsprogram.Eksamensgruppe", "0..*"),
            UTDANNINGSPROGRAM("no.fint.model.utdanning.utdanningsprogram.Utdanningsprogram", "0..*");
	
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

    private String domenenavn;
    private String juridiskNavn;
    @NotBlank
    private String navn;
    @NotNull
    private @Valid Identifikator skolenummer;
    @NotNull
    private @Valid Identifikator systemId;
}
