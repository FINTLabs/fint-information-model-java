package no.fint.model.personvern.samtykke;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Periode;
import java.util.Date;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Samtykke implements FintMainObject {
    public enum Relasjonsnavn {
            BEHANDLING,
            PERSON,
            ORGANISASJONSELEMENT
    }

    @NotNull
    private @Valid Periode gyldighetsperiode;
    @NotNull
    private Date opprettet;
    @NotNull
    private @Valid Identifikator systemId;
}
