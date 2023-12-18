package no.fint.model.utdanning.vurdering;

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
public class Eksamensgruppemedlemskap extends Gruppemedlemskap implements FintMainObject {
    public enum Relasjonsnavn {
            DELEGERTTIL("no.fint.model.utdanning.vurdering.Fylke", "0..1"),
            ELEVFORHOLD("no.fint.model.utdanning.vurdering.Elevforhold", "1"),
            FORETRUKKETSKOLE("no.fint.model.utdanning.vurdering.Skole", "0..1"),
            EKSAMENSGRUPPE("no.fint.model.utdanning.vurdering.Eksamensgruppe", "1"),
            NUS("no.fint.model.utdanning.vurdering.Karakterstatus", "0..1"),
            FORETRUKKETSENSOR("no.fint.model.utdanning.vurdering.Sensor", "0..1");
	
		private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }

        public String getTypeName() {
            return typeName;
        }

        public String getMultiplicity() {
            return multiplicity;
        }
    }

    private Boolean delegert;
    private String kandidatnummer;
}
