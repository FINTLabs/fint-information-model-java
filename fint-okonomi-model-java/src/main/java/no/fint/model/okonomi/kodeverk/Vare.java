package no.fint.model.okonomi.kodeverk;

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
import no.fint.model.administrasjon.kompleksedatatyper.Kontostreng;
import no.fint.model.felles.basisklasser.Begrep;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Vare extends Begrep implements FintMainObject {
    @Getter
    public enum Relasjonsnavn {
            FAKTURAUTSTEDER("no.fint.model.okonomi.faktura.Fakturautsteder", "1"),
            MERVERDIAVGIFT("no.fint.model.okonomi.kodeverk.Merverdiavgift", "1");
	
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


    @NotBlank
    private String enhet;
    private @Valid Kontostreng kontering;
    @NotNull
    private Long pris;
}
