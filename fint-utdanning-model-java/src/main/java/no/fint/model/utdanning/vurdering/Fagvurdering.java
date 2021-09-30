package no.fint.model.utdanning.vurdering;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintAbstractObject;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class Fagvurdering implements FintAbstractObject {
    public enum Relasjonsnavn {
            FAG,
            UNDERVISNINGSGRUPPE,
            SKOLEAR,
            KARAKTER
    }

    @NotBlank
    private String kommentar;
    @NotNull
    private @Valid Identifikator systemId;
    @NotNull
    private @Valid datetime vurderingsdato;
}
