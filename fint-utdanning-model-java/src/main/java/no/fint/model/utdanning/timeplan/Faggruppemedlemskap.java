package no.fint.model.utdanning.timeplan;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.utdanning.basisklasser.Gruppemedlemskap;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Faggruppemedlemskap extends Gruppemedlemskap implements FintMainObject {
    public enum Relasjonsnavn {
            FAGMERKNAD,
            FAGSTATUS,
            ELEVFORHOLD,
            FAGGRUPPE
    }

}
