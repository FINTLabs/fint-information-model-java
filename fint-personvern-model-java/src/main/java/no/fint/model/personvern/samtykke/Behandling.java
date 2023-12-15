package no.fint.model.personvern.samtykke;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Behandling implements FintMainObject {
    public enum Relasjonsnavn {
            BEHANDLINGSGRUNNLAG,
            PERSONOPPLYSNING,
            SAMTYKKE,
            TJENESTE
    }

    @NotNull
    private Boolean aktiv;
    @NotBlank
    private String formal;
    private @Valid Date slettet;
    @NotNull
    private @Valid  systemId;
}
