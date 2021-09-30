package no.fint.model.utdanning.vurdering;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.utdanning.vurdering.Fravarsprosent;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Fravarsoversikt implements FintMainObject {
    public enum Relasjonsnavn {
            ELEVFORHOLD,
            FAG
    }

    @NotNull
    private @Valid Fravarsprosent halvar;
    @NotNull
    private @Valid Fravarsprosent skolear;
    @NotNull
    private @Valid Identifikator systemId;
}
