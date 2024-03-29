package no.fint.model.utdanning.ot;

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
public class OtUngdom implements FintMainObject {
    public enum Relasjonsnavn {
            PERSON,
            STATUS,
            ENHET,
            PROGRAMOMRADE
    }

    @NotNull
    private @Valid Identifikator systemId;
}
