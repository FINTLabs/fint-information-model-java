package no.fint.model.utdanning.vurdering;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Periode;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Fravarsregistrering implements FintMainObject {
    public enum Relasjonsnavn {
            REGISTRERTAV("no.fint.model.utdanning.vurdering.Skoleressurs", "0..1"),
            FAGGRUPPE("no.fint.model.utdanning.vurdering.Faggruppe", "0..1"),
            UNDERVISNINGSGRUPPE("no.fint.model.utdanning.vurdering.Undervisningsgruppe", "1"),
            FRAVARSTYPE("no.fint.model.utdanning.vurdering.Fravarstype", "1"),
            ELEVFRAVAR("no.fint.model.utdanning.vurdering.Elevfravar", "1");
	
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
    private Boolean foresPaVitnemal;
    private String kommentar;
    @NotNull
    private @Valid Periode periode;
    @NotNull
    private @Valid Identifikator systemId;
}
