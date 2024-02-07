package no.fint.model.utdanning.elev;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
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
    @Getter
    public enum Relasjonsnavn {
            MEDLEM("no.fint.model.utdanning.basisklasser.Utdanningsforhold", "1"),
            FORTLOPENDEVURDERING("no.fint.model.utdanning.vurdering.Vurdering", "0..*"),
            GRUPPE("no.fint.model.utdanning.basisklasser.Gruppe", "1"),
            ENDELIGVURDERING("no.fint.model.utdanning.vurdering.Vurdering", "0..1"),
            FRAVAR("no.fint.model.utdanning.vurdering.Fravar", "0..*");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }
    }

    @Deprecated
    @NotNull
    private @Valid Identifikator systemId;
}
