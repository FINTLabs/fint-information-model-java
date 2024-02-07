package no.fint.model.utdanning.vurdering;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.utdanning.vurdering.Fagvurdering;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Sluttfagvurdering extends Fagvurdering implements FintMainObject {
    @Getter
    public enum Relasjonsnavn {
            ELEVFORHOLD("no.fint.model.utdanning.elev.Elevforhold", "1"),
            EKSAMENSGRUPPE("no.fint.model.utdanning.vurdering.Eksamensgruppe", "0..1"),
            KARAKTERHISTORIE("no.fint.model.utdanning.vurdering.Karakterhistorie", "0..*");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }
    }

}
