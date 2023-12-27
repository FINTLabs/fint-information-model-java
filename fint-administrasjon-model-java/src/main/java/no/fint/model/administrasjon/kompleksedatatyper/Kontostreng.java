package no.fint.model.administrasjon.kompleksedatatyper;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintComplexDatatypeObject;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Kontostreng implements FintComplexDatatypeObject {
    public enum Relasjonsnavn {
            AKTIVITET("no.fint.model.administrasjon.kodeverk.Aktivitet", "0..1"),
            ANLEGG("no.fint.model.administrasjon.kodeverk.Anlegg", "0..1"),
            ANSVAR("no.fint.model.administrasjon.kodeverk.Ansvar", "1"),
            ART("no.fint.model.administrasjon.kodeverk.Art", "1"),
            DIVERSE("no.fint.model.administrasjon.kodeverk.Diverse", "0..1"),
            FORMAL("no.fint.model.administrasjon.kodeverk.Formal", "0..1"),
            FUNKSJON("no.fint.model.administrasjon.kodeverk.Funksjon", "1"),
            KONTRAKT("no.fint.model.administrasjon.kodeverk.Kontrakt", "0..1"),
            LOPENUMMER("no.fint.model.administrasjon.kodeverk.Lopenummer", "0..1"),
            OBJEKT("no.fint.model.administrasjon.kodeverk.Objekt", "0..1"),
            PROSJEKT("no.fint.model.administrasjon.kodeverk.Prosjekt", "0..1"),
            PROSJEKTART("no.fint.model.administrasjon.kodeverk.Prosjektart", "0..1"),
            RAMME("no.fint.model.administrasjon.kodeverk.Ramme", "0..1");
	
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

}
