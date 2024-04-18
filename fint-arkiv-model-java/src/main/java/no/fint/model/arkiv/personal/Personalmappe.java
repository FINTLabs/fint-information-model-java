package no.fint.model.arkiv.personal;

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
import no.fint.model.FintMainObject;
import no.fint.model.FintIdentifikator;
import no.fint.model.FintRelation;
import no.fint.model.felles.kompleksedatatyper.Personnavn;
import no.fint.model.arkiv.noark.Saksmappe;

import static no.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Personalmappe extends Saksmappe  implements FintMainObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
            PERSON("person", "no.fint.model.felles.Person", ONE_TO_ONE),
            LEDER("leder", "no.fint.model.administrasjon.personal.Personalressurs", ONE_TO_ONE),
            ARBEIDSSTED("arbeidssted", "no.fint.model.administrasjon.organisasjon.Organisasjonselement", ONE_TO_ONE),
            PERSONALRESSURS("personalressurs", "no.fint.model.administrasjon.personal.Personalressurs", ONE_TO_ONE);
	
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
		identifikators.putAll(super.getIdentifikators());
    
    	return identifikators;
	}
	@JsonIgnore
	private final List<FintRelation> relations = new ArrayList<>(Arrays.asList(Relasjonsnavn.values()));
    @NotNull
    private @Valid Personnavn navn;
}
