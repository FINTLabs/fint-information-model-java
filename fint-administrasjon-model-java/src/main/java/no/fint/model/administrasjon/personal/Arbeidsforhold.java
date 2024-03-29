package no.fint.model.administrasjon.personal;

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
public class Arbeidsforhold implements FintMainObject {
    public enum Relasjonsnavn {
            AKTIVITET,
            ANLEGG,
            ANSVAR,
            ARBEIDSFORHOLDSTYPE,
            ART,
            DIVERSE,
            FORMAL,
            FUNKSJON,
            KONTRAKT,
            LOPENUMMER,
            OBJEKT,
            PROSJEKT,
            RAMME,
            STILLINGSKODE,
            TIMERPERUKE,
            ARBEIDSLOKASJON,
            ARBEIDSSTED,
            PERSONALLEDER,
            FASTLONN,
            FASTTILLEGG,
            FRAVAR,
            LONN,
            VARIABELLONN,
            PERSONALRESSURS,
            UNDERVISNINGSFORHOLD
    }

    @NotNull
    private Long ansettelsesprosent;
    private @Valid Periode arbeidsforholdsperiode;
    @NotNull
    private Long arslonn;
    @NotNull
    private @Valid Periode gyldighetsperiode;
    @NotNull
    private Boolean hovedstilling;
    @NotNull
    private Long lonnsprosent;
    @NotBlank
    private String stillingsnummer;
    private String stillingstittel;
    @NotNull
    private @Valid Identifikator systemId;
    @NotNull
    private Long tilstedeprosent;
}
