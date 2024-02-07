package no.fint.model.utdanning.timeplan;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
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
    @Getter
    public enum Relasjonsnavn {
            FAGMERKNAD("no.fint.model.utdanning.kodeverk.Fagmerknad", "0..1"),
            FAGSTATUS("no.fint.model.utdanning.kodeverk.Fagstatus", "0..1"),
            ELEVFORHOLD("no.fint.model.utdanning.elev.Elevforhold", "1"),
            FAGGRUPPE("no.fint.model.utdanning.timeplan.Faggruppe", "1");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }
    }

}
