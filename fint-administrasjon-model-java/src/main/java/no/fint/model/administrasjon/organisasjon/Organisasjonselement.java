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
import no.fint.model.felles.kompleksedatatyper.Periode;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.felles.basisklasser.Enhet;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Organisasjonselement extends Enhet implements FintMainObject {
    @Getter
    public enum Relasjonsnavn {
            ANSVAR("no.fint.model.administrasjon.kodeverk.Ansvar", "0..*"),
            LEDER("no.fint.model.administrasjon.personal.Personalressurs", "0..1"),
            OVERORDNET("no.fint.model.administrasjon.organisasjon.Organisasjonselement", "1"),
            UNDERORDNET("no.fint.model.administrasjon.organisasjon.Organisasjonselement", "0..*"),
            SKOLE("no.fint.model.utdanning.utdanningsprogram.Skole", "0..1"),
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
		identifikators.put("organisasjonsId", this.organisasjonsId);
		identifikators.put("organisasjonsKode", this.organisasjonsKode);
    
    	return identifikators;
	}


    private @Valid Periode gyldighetsperiode;
    private String kortnavn;
    private String navn;
    @NotNull
    private @Valid Identifikator organisasjonsId;
    @NotNull
    private @Valid Identifikator organisasjonsKode;
}
