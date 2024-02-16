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
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.felles.kompleksedatatyper.Adresse;
import no.fint.model.felles.kompleksedatatyper.Kontaktinformasjon;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Elev implements FintMainObject {
    @Getter
    public enum Relasjonsnavn {
            PERSON("no.fint.model.felles.Person", "1"),
            ELEVFORHOLD("no.fint.model.utdanning.elev.Elevforhold", "0..*");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }
    }


	public Map<String, Identifikator> getIdentifikators() {
    	Map<String, Identifikator> identifikators = new HashMap<>();
		identifikators.put("brukernavn", this.brukernavn);
		identifikators.put("elevnummer", this.elevnummer);
		identifikators.put("feidenavn", this.feidenavn);
		identifikators.put("systemId", this.systemId);
    
    	return identifikators;
	}


    private @Valid Identifikator brukernavn;
    private @Valid Identifikator elevnummer;
    private @Valid Identifikator feidenavn;
    private Boolean gjest;
    private @Valid Adresse hybeladresse;
    private @Valid Kontaktinformasjon kontaktinformasjon;
    @NotNull
    private @Valid Identifikator systemId;
}
