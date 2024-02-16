package no.fint.model.administrasjon.organisasjon;

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
import no.fint.model.felles.basisklasser.Enhet;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Arbeidslokasjon extends Enhet implements FintMainObject {
    @Getter
    public enum Relasjonsnavn {
            ARBEIDSFORHOLD("no.fint.model.administrasjon.personal.Arbeidsforhold", "0..*");
	
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
		identifikators.put("lokasjonskode", this.lokasjonskode);
    
    	return identifikators;
	}


    @NotNull
    private @Valid Identifikator lokasjonskode;
    private String lokasjonsnavn;
}
