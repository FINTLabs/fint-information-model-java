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
import no.fint.model.FintComplexDatatypeObject;
import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Merknad implements FintComplexDatatypeObject {
    @Getter
    public enum Relasjonsnavn {
            MERKNADSTYPE("no.fint.model.arkiv.kodeverk.Merknadstype", "1"),
            MERKNADREGISTRERTAV("no.fint.model.arkiv.noark.Arkivressurs", "1");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }
    }


	public Map<String, Identifikator> getIdentifikators() {
    	Map<String, Identifikator> identifikators = new HashMap<>();
    
    	return identifikators;
	}


    @NotNull
    private @Valid Date merknadsdato;
    @NotBlank
    private String merknadstekst;
}
