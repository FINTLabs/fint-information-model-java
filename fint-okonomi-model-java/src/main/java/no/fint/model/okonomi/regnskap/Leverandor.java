package no.fint.model.okonomi.regnskap;

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
public class Leverandor implements FintMainObject {
    @Getter
    public enum Relasjonsnavn {
            PERSON("no.fint.model.felles.Person", "0..1"),
            LEVERANDORGRUPPE("no.fint.model.okonomi.regnskap.Leverandorgruppe", "0..1"),
            VIRKSOMHET("no.fint.model.felles.Virksomhet", "0..1");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }
    }


	public Map<String, Identifikator> getIdentifikators() {
    	Map<String, Identifikator> identifikators = new HashMap<>();
		identifikators.put("leverandornummer", this.leverandornummer);
		identifikators.put("systemId", this.systemId);
    
    	return identifikators;
	}


    private String kontonummer;
    private @Valid Identifikator leverandornummer;
    @NotNull
    private @Valid Identifikator systemId;
}
