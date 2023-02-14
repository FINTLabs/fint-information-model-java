package no.fint.model.okonomi.regnskap;

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
public class Leverandor implements FintMainObject {
    public enum Relasjonsnavn {
            PERSON,
            LEVERANDORGRUPPE,
            VIRKSOMHET
    }

    private String kontonummer;
    private @Valid Identifikator leverandornummer;
    @NotNull
    private @Valid Identifikator systemId;
}
