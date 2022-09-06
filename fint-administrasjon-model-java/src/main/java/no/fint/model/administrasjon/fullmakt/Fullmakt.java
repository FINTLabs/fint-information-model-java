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
            MYNDIGHET,
            RAMME,
            FUNKSJON,
            OBJEKT,
            ORGANISASJONSELEMENT,
            ART,
            ANLEGG,
            DIVERSE,
            AKTIVITET,
            ANSVAR,
            STEDFORTREDER,
            KONTRAKT,
            FULLMEKTIG,
            PROSJEKT,
            FORMAL,
            ROLLE,
            LOPENUMMER
    }

    @NotNull
    private @Valid Periode gyldighetsperiode;
    @NotNull
    private @Valid Identifikator systemId;
}
