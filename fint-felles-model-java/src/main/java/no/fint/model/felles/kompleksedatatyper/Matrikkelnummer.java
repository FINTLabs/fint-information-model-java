package no.fint.model.felles.kompleksedatatyper;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
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
    @Getter
    public enum Relasjonsnavn {
            KOMMUNENUMMER("no.fint.model.felles.kodeverk.Kommune", "0..1");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }
    }

    private @Valid Adresse adresse;
    private String bruksnummer;
    private String festenummer;
    private String gardsnummer;
    private String seksjonsnummer;
}
