package no.fint.model.administrasjon.personal;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.administrasjon.personal.Lonn;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Fastlonn extends Lonn implements FintMainObject {
    public enum Relasjonsnavn {
            LONNSART("no.fint.model.administrasjon.personal.Lonnsart", "0..1"),
            ARBEIDSFORHOLD("no.fint.model.administrasjon.personal.Arbeidsforhold", "1");
	
		private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }

        public String getTypeName() {
            return typeName;
        }

        public String getMultiplicity() {
            return multiplicity;
        }
    }

    @NotNull
    private Long prosent;
}
