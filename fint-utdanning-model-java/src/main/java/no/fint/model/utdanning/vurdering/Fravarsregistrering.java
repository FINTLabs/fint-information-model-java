package no.fint.model.utdanning.vurdering;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintComplexDatatypeObject;
import no.fint.model.felles.kompleksedatatyper.Periode;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Fravarsregistrering implements FintComplexDatatypeObject {
    public enum Relasjonsnavn {
            REGISTRERTAV,
            UNDERVISNINGSGRUPPE,
            FRAVARSTYPE
    }

    @NotNull
    private Boolean foresPaVitnemal;
    @NotBlank
    private String kommentar;
    @NotNull
    private @Valid Periode periode;
}
