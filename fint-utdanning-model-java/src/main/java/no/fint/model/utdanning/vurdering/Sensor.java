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
public class Sensor implements FintMainObject {
    public enum Relasjonsnavn {
            SKOLERESSURS,
            EKSAMENSGRUPPE
    }

    @NotNull
    private Boolean aktiv;
    private Integer sensornummer;
    @NotNull
    private @Valid Identifikator systemId;
}
