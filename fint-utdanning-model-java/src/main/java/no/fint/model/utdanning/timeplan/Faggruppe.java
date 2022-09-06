package no.fint.model.utdanning.timeplan;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Faggruppe implements FintMainObject {
    public enum Relasjonsnavn {
            FAG,
            FAGGRUPPEMEDLEMSKAP
    }

}
