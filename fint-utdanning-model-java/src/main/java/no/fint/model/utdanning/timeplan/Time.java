package no.fint.model.utdanning.timeplan;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.felles.kompleksedatatyper.Periode;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Time implements FintMainObject {
    public enum Relasjonsnavn {
            UNDERVISNINGSGRUPPE("no.fint.model.utdanning.timeplan.Undervisningsgruppe", "1..*"),
            UNDERVISNINGSFORHOLD("no.fint.model.utdanning.timeplan.Undervisningsforhold", "1..*"),
            ROM("no.fint.model.utdanning.timeplan.Rom", "0..*");
	
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

    private String beskrivelse;
    @NotBlank
    private String navn;
    @NotNull
    private @Valid Identifikator systemId;
    @NotNull
    private @Valid Periode tidsrom;
}
