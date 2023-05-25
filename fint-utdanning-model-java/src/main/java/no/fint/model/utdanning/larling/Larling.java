package no.fint.model.utdanning.larling;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Periode;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Larling implements FintMainObject {
    public enum Relasjonsnavn {
            PERSON,
            BEDRIFT,
            PROGRAMOMRADE
    }

    private String kontraktstype;
    private @Valid Periode laretid;
    @NotNull
    private @Valid Identifikator systemId;
}
