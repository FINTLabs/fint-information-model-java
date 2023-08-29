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
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Tjeneste implements FintMainObject {
    public enum Relasjonsnavn {
            BEHANDLING
    }

    @NotBlank
    private String navn;
    private @Valid Date slettet;
    @NotNull
    private @Valid Identifikator systemId;
}
