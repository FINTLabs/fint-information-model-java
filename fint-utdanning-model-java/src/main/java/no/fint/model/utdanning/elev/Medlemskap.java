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
            GRUPPE,
            FORTLOPENDEVURDERING,
            ENDELIGVURDERING,
            FRAVAR,
            MEDLEM
    }

    @Deprecated
    @NotNull
    private @Valid Identifikator systemId;
}
