package no.fint.model.utdanning.timeplan;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.felles.kompleksedatatyper.Periode;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Eksamen implements FintMainObject {
    public enum Relasjonsnavn {
            ROM,
            EKSAMENSGRUPPE
    }

    private String beskrivelse;
    @NotBlank
    private String navn;
    @NotNull
    private @Valid Identifikator systemId;
    @NotNull
    private @Valid Periode tidsrom;
}
