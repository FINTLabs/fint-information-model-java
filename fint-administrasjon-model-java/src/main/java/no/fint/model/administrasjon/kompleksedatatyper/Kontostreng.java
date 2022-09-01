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
            AKTIVITET,
            ANLEGG,
            ANSVAR,
            ART,
            DIVERSE,
            FORMAL,
            FUNKSJON,
            KONTRAKT,
            LOPENUMMER,
            OBJEKT,
            PROSJEKT,
            RAMME
    }

}
