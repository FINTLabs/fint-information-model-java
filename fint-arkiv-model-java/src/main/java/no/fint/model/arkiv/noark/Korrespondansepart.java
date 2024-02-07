package no.fint.model.arkiv.noark;

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
import no.fint.model.felles.kompleksedatatyper.Kontaktinformasjon;
import no.fint.model.arkiv.noark.Skjerming;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Korrespondansepart implements FintComplexDatatypeObject {
    @Getter
    public enum Relasjonsnavn {
            KORRESPONDANSEPARTTYPE("no.fint.model.arkiv.kodeverk.KorrespondansepartType", "1");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }
    }

    private @Valid Adresse adresse;
    private String fodselsnummer;
    private @Valid Kontaktinformasjon kontaktinformasjon;
    private String kontaktperson;
    private String korrespondansepartNavn;
    private String organisasjonsnummer;
    private @Valid Skjerming skjerming;
}
