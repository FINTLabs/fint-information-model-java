package no.fint.model.utdanning.vurdering;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import java.util.Date;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Karakterhistorie implements FintMainObject {
    public enum Relasjonsnavn {
            OPPDATERTAV("no.fint.model.utdanning.vurdering.Skoleressurs", "0..1"),
            OPPRINNELIGKARAKTERVERDI("no.fint.model.utdanning.vurdering.Karakterverdi", "0..1"),
            OPPRINNELIGKARAKTERSTATUS("no.fint.model.utdanning.vurdering.Karakterstatus", "0..1"),
            KARAKTERVERDI("no.fint.model.utdanning.vurdering.Karakterverdi", "0..1"),
            KARAKTERSTATUS("no.fint.model.utdanning.vurdering.Karakterstatus", "0..1");
	
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

    @NotNull
    private @Valid Date endretDato;
    @NotNull
    private @Valid Identifikator systemId;
}
