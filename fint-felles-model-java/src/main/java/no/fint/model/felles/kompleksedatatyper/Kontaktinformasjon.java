// Built from tag v3.6.0-rc-1

package no.fint.model.felles.kompleksedatatyper;

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
public class Kontaktinformasjon implements FintComplexDatatypeObject {
    private String epostadresse;
    private String mobiltelefonnummer;
    private String nettsted;
    private String sip;
    private String telefonnummer;
}
