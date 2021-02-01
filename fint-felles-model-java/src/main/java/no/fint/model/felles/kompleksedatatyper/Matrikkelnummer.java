package no.fint.model.felles.kompleksedatatyper;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintComplexDatatypeObject;
import no.fint.model.felles.kompleksedatatyper.Adresse;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Matrikkelnummer implements FintComplexDatatypeObject {
    public enum Relasjonsnavn {
            KOMMUNENUMMER
    }

    private @Valid Adresse adresse;
    private String bruksnummer;
    private String festenummer;
    private String gardsnummer;
    private String seksjonsnummer;
}
