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
import no.fint.model.felles.kompleksedatatyper.Adresse;
import no.fint.model.felles.kompleksedatatyper.Kontaktinformasjon;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Part implements FintComplexDatatypeObject {
    @Getter
    public enum Relasjonsnavn {
            PARTROLLE("no.fint.model.arkiv.kodeverk.PartRolle", "0..1");
	
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


    private @Valid Adresse adresse;
    private @Valid Kontaktinformasjon kontaktinformasjon;
    private String kontaktperson;
    @NotBlank
    private String partNavn;
}
