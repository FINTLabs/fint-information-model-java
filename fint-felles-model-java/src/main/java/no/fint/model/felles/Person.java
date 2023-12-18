package no.fint.model.felles;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Adresse;
import java.util.Date;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.felles.kompleksedatatyper.Personnavn;
import no.fint.model.felles.basisklasser.Aktor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Person extends Aktor implements FintMainObject {
    public enum Relasjonsnavn {
            STATSBORGERSKAP("no.fint.model.felles.Landkode", "0..*"),
            KOMMUNE("no.fint.model.felles.Kommune", "0..1"),
            KJONN("no.fint.model.felles.Kjonn", "0..1"),
            FORELDREANSVAR("no.fint.model.felles.Person", "0..*"),
            MALFORM("no.fint.model.felles.Sprak", "0..1"),
            PERSONALRESSURS("no.fint.model.felles.Personalressurs", "0..1"),
            MORSMAL("no.fint.model.felles.Sprak", "0..1"),
            PARORENDE("no.fint.model.felles.Kontaktperson", "0..*"),
            FORELDRE("no.fint.model.felles.Person", "0..*"),
            LARLING("no.fint.model.felles.Larling", "0..*"),
            ELEV("no.fint.model.felles.Elev", "0..1"),
            OTUNGDOM("no.fint.model.felles.OtUngdom", "0..1");
	
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

    private String bilde;
    private @Valid Adresse bostedsadresse;
    private Date fodselsdato;
    @NotNull
    private @Valid Identifikator fodselsnummer;
    @NotNull
    private @Valid Personnavn navn;
}
