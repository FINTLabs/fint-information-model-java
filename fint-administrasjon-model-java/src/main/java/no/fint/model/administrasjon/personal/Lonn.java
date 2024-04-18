package no.fint.model.administrasjon.personal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMultiplicity;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.FintAbstractObject;
import no.fint.model.FintIdentifikator;
import no.fint.model.FintRelation;
import java.util.Date;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.administrasjon.kompleksedatatyper.Kontostreng;
import no.fint.model.felles.kompleksedatatyper.Periode;

import static no.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class Lonn  implements FintAbstractObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
            ANVISER("anviser", "no.fint.model.administrasjon.personal.Personalressurs", NONE_TO_ONE),
            KONTERER("konterer", "no.fint.model.administrasjon.personal.Personalressurs", NONE_TO_ONE),
            ATTESTANT("attestant", "no.fint.model.administrasjon.personal.Personalressurs", NONE_TO_ONE);
	
		private final String name;
        private final String packageName;
        private final FintMultiplicity multiplicity;

        private Relasjonsnavn(String name, String packageName, FintMultiplicity multiplicity) {
			this.name = name;
            this.packageName = packageName;
            this.multiplicity = multiplicity;
        }
    }

	@JsonIgnore
	public Map<String, FintIdentifikator> getIdentifikators() {
    	Map<String, FintIdentifikator> identifikators = new HashMap<>();
		identifikators.put("kildesystemId", this.kildesystemId);
		identifikators.put("systemId", this.systemId);
    
    	return identifikators;
	}
	@JsonIgnore
	private final List<FintRelation> relations = new ArrayList<>(Arrays.asList(FintRelation.values()));
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
