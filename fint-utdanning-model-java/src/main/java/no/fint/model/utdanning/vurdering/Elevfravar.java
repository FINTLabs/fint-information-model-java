package no.fint.model.utdanning.vurdering;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.utdanning.vurdering.Fravarsregistrering;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Elevfravar implements FintMainObject {
    public enum Relasjonsnavn {
            ELEVFORHOLD
    }

    private List<@Valid Fravarsregistrering> fravar;
    @NotNull
    private @Valid Identifikator systemId;
}
