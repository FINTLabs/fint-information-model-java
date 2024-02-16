package no.fint.model.administrasjon.personal;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.FintAbstractObject;
import java.util.Date;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.administrasjon.kompleksedatatyper.Kontostreng;
import no.fint.model.felles.kompleksedatatyper.Periode;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class Lonn implements FintAbstractObject {
    @Getter
    public enum Relasjonsnavn {
            ANVISER("no.fint.model.administrasjon.personal.Personalressurs", "0..1"),
            KONTERER("no.fint.model.administrasjon.personal.Personalressurs", "0..1"),
            ATTESTANT("no.fint.model.administrasjon.personal.Personalressurs", "0..1");
	
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


    private @Valid Date anvist;
    private @Valid Date attestert;
    @NotBlank
    private String beskrivelse;
    private @Valid Identifikator kildesystemId;
    private @Valid Date kontert;
    @NotNull
    private @Valid Kontostreng kontostreng;
    private @Valid Periode opptjent;
    @NotNull
    private @Valid Periode periode;
    private @Valid Identifikator systemId;
}
