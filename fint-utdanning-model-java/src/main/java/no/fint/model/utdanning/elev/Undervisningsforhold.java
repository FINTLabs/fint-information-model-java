package no.fint.model.utdanning.elev;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.FintMainObject;
import no.fint.model.utdanning.basisklasser.Utdanningsforhold;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Undervisningsforhold extends Utdanningsforhold implements FintMainObject {
    @Getter
    public enum Relasjonsnavn {
            ARBEIDSFORHOLD("no.fint.model.administrasjon.personal.Arbeidsforhold", "1"),
            BASISGRUPPE("no.fint.model.utdanning.elev.Basisgruppe", "0..*"),
            KONTAKTLARERGRUPPE("no.fint.model.utdanning.elev.Kontaktlarergruppe", "0..*"),
            UNDERVISNINGSGRUPPE("no.fint.model.utdanning.timeplan.Undervisningsgruppe", "0..*"),
            EKSAMENSGRUPPE("no.fint.model.utdanning.vurdering.Eksamensgruppe", "0..*"),
            TIME("no.fint.model.utdanning.timeplan.Time", "0..*"),
            SKOLE("no.fint.model.utdanning.utdanningsprogram.Skole", "1"),
            SKOLERESSURS("no.fint.model.utdanning.elev.Skoleressurs", "1");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }
    }


	public Map<String, Identifikator> getIdentifikators() {
    	Map<String, Identifikator> identifikators = new HashMap<>();
		identifikators.putAll(super.getIdentifikators());
    
    	return identifikators;
	}


    private Boolean hovedskole;
}
