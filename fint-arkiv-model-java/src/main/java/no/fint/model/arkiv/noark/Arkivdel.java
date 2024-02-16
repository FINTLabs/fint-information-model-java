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
public class Arkivdel implements FintMainObject {
    @Getter
    public enum Relasjonsnavn {
            KLASSIFIKASJONSSYSTEM("no.fint.model.arkiv.noark.Klassifikasjonssystem", "0..*"),
            REGISTRERING("no.fint.model.arkiv.noark.Registrering", "0..*"),
            MAPPE("no.fint.model.arkiv.noark.Mappe", "0..*");
	
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
    @NotBlank
    private String tittel;
}
