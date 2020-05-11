// Built from tag v3.5.0

package no.fint.model.administrasjon.kompleksedatatyper;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.NonNull;
import java.util.List;
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
            FUNKSJON,
            KONTRAKT,
            LOPENUMMER,
            OBJEKT,
            PROSJEKT,
            RAMME
    }

}
