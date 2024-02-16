package no.fint.model.arkiv.noark;

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
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Arkivressurs implements FintMainObject {
    @Getter
    public enum Relasjonsnavn {
            PERSONALRESSURS("no.fint.model.administrasjon.personal.Personalressurs", "1"),
            AUTORISASJON("no.fint.model.arkiv.noark.Autorisasjon", "0..*"),
            TILGANG("no.fint.model.arkiv.noark.Tilgang", "0..*");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }
    }


	public Map<String, Identifikator> getIdentifikators() {
    	Map<String, Identifikator> identifikators = new HashMap<>();
		identifikators.put("kildesystemId", this.kildesystemId);
		identifikators.put("systemId", this.systemId);
    
    	return identifikators;
	}


    private @Valid Identifikator kildesystemId;
    private @Valid Identifikator systemId;
}
