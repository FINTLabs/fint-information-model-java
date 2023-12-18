package no.fint.model.utdanning.elev;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Deprecated
public class Medlemskap implements FintMainObject {
    public enum Relasjonsnavn {
            MEDLEM("no.fint.model.utdanning.elev.Utdanningsforhold", "1"),
            FORTLOPENDEVURDERING("no.fint.model.utdanning.elev.Vurdering", "0..*"),
            GRUPPE("no.fint.model.utdanning.elev.Gruppe", "1"),
            ENDELIGVURDERING("no.fint.model.utdanning.elev.Vurdering", "0..1"),
            FRAVAR("no.fint.model.utdanning.elev.Fravar", "0..*");
	
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

    @Deprecated
    @NotNull
    private @Valid Identifikator systemId;
}
