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
            ORGANISASJON("no.fint.model.administrasjon.organisasjon.Organisasjonselement", "0..1"),
            FAG("no.fint.model.utdanning.timeplan.Fag", "0..*"),
            SKOLEEIERTYPE("no.fint.model.utdanning.kodeverk.Skoleeiertype", "0..1"),
            VIGOREFERANSE("no.fint.model.utdanning.kodeverk.Vigoreferanse", "0..1"),
            BASISGRUPPE("no.fint.model.utdanning.elev.Basisgruppe", "0..*"),
            ELEVFORHOLD("no.fint.model.utdanning.elev.Elevforhold", "0..*"),
            KONTAKTLARERGRUPPE("no.fint.model.utdanning.elev.Kontaktlarergruppe", "0..*"),
            SKOLERESSURS("no.fint.model.utdanning.elev.Skoleressurs", "0..*"),
            UNDERVISNINGSFORHOLD("no.fint.model.utdanning.elev.Undervisningsforhold", "0..*"),
            FAGGRUPPE("no.fint.model.utdanning.timeplan.Faggruppe", "0..*"),
            UNDERVISNINGSGRUPPE("no.fint.model.utdanning.timeplan.Undervisningsgruppe", "0..*"),
            EKSAMENSGRUPPE("no.fint.model.utdanning.vurdering.Eksamensgruppe", "0..*"),
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
