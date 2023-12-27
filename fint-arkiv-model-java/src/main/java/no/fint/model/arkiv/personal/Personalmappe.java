package no.fint.model.arkiv.personal;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Personnavn;
import no.fint.model.arkiv.noark.Saksmappe;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Personalmappe extends Saksmappe implements FintMainObject {
    public enum Relasjonsnavn {
            PERSON("no.fint.model.felles.Person", "1"),
            LEDER("no.fint.model.administrasjon.personal.Personalressurs", "1"),
            ARBEIDSSTED("no.fint.model.administrasjon.organisasjon.Organisasjonselement", "1"),
            PERSONALRESSURS("no.fint.model.administrasjon.personal.Personalressurs", "1");
	
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
    private @Valid Personnavn navn;
}
