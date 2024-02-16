package no.fint.model.utdanning.ot;

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
public class OtUngdom implements FintMainObject {
    @Getter
    public enum Relasjonsnavn {
            PERSON("no.fint.model.felles.Person", "1"),
            STATUS("no.fint.model.utdanning.kodeverk.OtStatus", "0..1"),
            ENHET("no.fint.model.utdanning.kodeverk.OtEnhet", "0..1"),
            PROGRAMOMRADE("no.fint.model.utdanning.utdanningsprogram.Programomrade", "0..1");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }
    }


	public Map<String, Identifikator> getIdentifikators() {
    	Map<String, Identifikator> identifikators = new HashMap<>();
		identifikators.put("systemId", this.systemId);
    
    	return identifikators;
	}


    @NotNull
    private @Valid Identifikator systemId;
}
