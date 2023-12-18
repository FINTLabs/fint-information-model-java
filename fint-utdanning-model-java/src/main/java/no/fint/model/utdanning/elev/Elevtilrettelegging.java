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
public class Elevtilrettelegging implements FintMainObject {
    public enum Relasjonsnavn {
            ELEV("no.fint.model.utdanning.elev.Elevforhold", "1"),
            FAG("no.fint.model.utdanning.elev.Fag", "0..1"),
            TILRETTELEGGING("no.fint.model.utdanning.elev.Tilrettelegging", "1");
	
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
    private @Valid Identifikator systemId;
}
