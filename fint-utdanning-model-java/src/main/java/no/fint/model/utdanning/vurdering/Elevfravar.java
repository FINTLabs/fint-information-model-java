package no.fint.model.utdanning.vurdering;

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
public class Elevfravar implements FintMainObject {
    @Getter
    public enum Relasjonsnavn {
            FRAVARSREGISTRERING("no.fint.model.utdanning.vurdering.Fravarsregistrering", "0..*"),
            ELEVFORHOLD("no.fint.model.utdanning.elev.Elevforhold", "1");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }
    }

    @NotNull
    private @Valid Identifikator systemId;
}
