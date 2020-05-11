// Built from tag v3.5.0

package no.fint.model.administrasjon.personal;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.NonNull;
import java.util.List;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.felles.kompleksedatatyper.Periode;
import java.util.Date;
import no.fint.model.felles.kompleksedatatyper.Kontaktinformasjon;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Personalressurs implements FintMainObject {
    public enum Relasjonsnavn {
            PERSONALRESSURSKATEGORI,
            ARBEIDSFORHOLD,
            PERSON,
            STEDFORTREDER,
            FULLMAKT,
            LEDER,
            PERSONALANSVAR,
            SKOLERESSURS
    }

    @NonNull
    private Identifikator ansattnummer;
    @NonNull
    private Periode ansettelsesperiode;
    private Date ansiennitet;
    private Identifikator brukernavn;
    private Kontaktinformasjon kontaktinformasjon;
    private Identifikator systemId;
}
