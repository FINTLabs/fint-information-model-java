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
@Deprecated
public class Vurdering implements FintMainObject {
    public enum Relasjonsnavn {
            ELEVFORHOLD,
            FAG,
            UNDERVISNINGSGRUPPE,
            EKSAMENSGRUPPE,
            KARAKTER
    }

    @NotNull
    private Boolean endelig;
    @NotBlank
    private String kommentar;
    @NotNull
    private @Valid Identifikator systemId;
}
