package no.fint.model.administrasjon.fullmakt;

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
public class Rolle implements FintMainObject {
    public enum Relasjonsnavn {
            FULLMAKT
    }

    @NotBlank
    private String beskrivelse;
    @NotNull
    private @Valid Identifikator navn;
}
