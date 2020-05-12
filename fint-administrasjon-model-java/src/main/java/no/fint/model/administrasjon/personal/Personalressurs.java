// Built from tag v3.5.0

package no.fint.model.administrasjon.personal;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
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

    @NotNull
    private @Valid Identifikator ansattnummer;
    @NotNull
    private @Valid Periode ansettelsesperiode;
    private Date ansiennitet;
    private @Valid Identifikator brukernavn;
    private @Valid Kontaktinformasjon kontaktinformasjon;
    private @Valid Identifikator systemId;
}
