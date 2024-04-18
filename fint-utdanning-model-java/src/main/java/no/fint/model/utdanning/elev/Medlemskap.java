package no.fint.model.utdanning.elev;

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
import no.fint.model.felles.kompleksedatatyper.Identifikator;

import static no.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Deprecated
public class Medlemskap  implements FintMainObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
            MEDLEM("medlem", "no.fint.model.utdanning.basisklasser.Utdanningsforhold", ONE_TO_ONE),
            FORTLOPENDEVURDERING("fortlopendeVurdering", "no.fint.model.utdanning.vurdering.Vurdering", NONE_TO_MANY),
            GRUPPE("gruppe", "no.fint.model.utdanning.basisklasser.Gruppe", ONE_TO_ONE),
            ENDELIGVURDERING("endeligVurdering", "no.fint.model.utdanning.vurdering.Vurdering", NONE_TO_ONE),
            FRAVAR("fravar", "no.fint.model.utdanning.vurdering.Fravar", NONE_TO_MANY);
	
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
		identifikators.put("systemId", this.systemId);
    
    	return identifikators;
	}
	@JsonIgnore
	private final List<FintRelation> relations = new ArrayList<>(Arrays.asList(FintRelation.values()));
    @Deprecated
    @NotNull
    private @Valid Identifikator systemId;
}
