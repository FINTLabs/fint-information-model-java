package no.fint.model.utdanning.vurdering;

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
public class Anmerkninger implements FintMainObject {
    public enum Relasjonsnavn {
            SKOLEAR
    }

    @NotNull
    private Integer atferd;
    @NotNull
    private Integer orden;
    @NotNull
    private @Valid Identifikator systemId;
}
