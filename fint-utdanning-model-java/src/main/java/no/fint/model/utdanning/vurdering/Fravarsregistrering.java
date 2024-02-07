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
import no.fint.model.felles.kompleksedatatyper.Periode;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Fravarsregistrering implements FintMainObject {
    @Getter
    public enum Relasjonsnavn {
            REGISTRERTAV("no.fint.model.utdanning.elev.Skoleressurs", "0..1"),
            FAGGRUPPE("no.fint.model.utdanning.timeplan.Faggruppe", "0..1"),
            UNDERVISNINGSGRUPPE("no.fint.model.utdanning.timeplan.Undervisningsgruppe", "1"),
            FRAVARSTYPE("no.fint.model.utdanning.kodeverk.Fravarstype", "1"),
            ELEVFRAVAR("no.fint.model.utdanning.vurdering.Elevfravar", "1");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
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
