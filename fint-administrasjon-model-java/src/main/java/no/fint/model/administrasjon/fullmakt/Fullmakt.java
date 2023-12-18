package no.fint.model.administrasjon.fullmakt;

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
public class Fullmakt implements FintMainObject {
    public enum Relasjonsnavn {
            MYNDIGHET("no.fint.model.administrasjon.fullmakt.Kontodimensjon", "0..*"),
            RAMME("no.fint.model.administrasjon.fullmakt.Ramme", "0..1"),
            FUNKSJON("no.fint.model.administrasjon.fullmakt.Funksjon", "0..1"),
            OBJEKT("no.fint.model.administrasjon.fullmakt.Objekt", "0..1"),
            ORGANISASJONSELEMENT("no.fint.model.administrasjon.fullmakt.Organisasjonselement", "0..1"),
            ART("no.fint.model.administrasjon.fullmakt.Art", "0..1"),
            ANLEGG("no.fint.model.administrasjon.fullmakt.Anlegg", "0..1"),
            DIVERSE("no.fint.model.administrasjon.fullmakt.Diverse", "0..1"),
            AKTIVITET("no.fint.model.administrasjon.fullmakt.Aktivitet", "0..1"),
            ANSVAR("no.fint.model.administrasjon.fullmakt.Ansvar", "0..1"),
            STEDFORTREDER("no.fint.model.administrasjon.fullmakt.Personalressurs", "0..1"),
            KONTRAKT("no.fint.model.administrasjon.fullmakt.Kontrakt", "0..1"),
            FULLMEKTIG("no.fint.model.administrasjon.fullmakt.Personalressurs", "0..1"),
            PROSJEKT("no.fint.model.administrasjon.fullmakt.Prosjekt", "0..1"),
            FORMAL("no.fint.model.administrasjon.fullmakt.Formal", "0..1"),
            ROLLE("no.fint.model.administrasjon.fullmakt.Rolle", "1"),
            LOPENUMMER("no.fint.model.administrasjon.fullmakt.Lopenummer", "0..1");
	
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
    private @Valid Periode gyldighetsperiode;
    @NotNull
    private @Valid Identifikator systemId;
}
