// Built from tag v3.5.0

package no.fint.model.utdanning.elev;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.felles.kompleksedatatyper.Kontaktinformasjon;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Elev implements FintMainObject {
    public enum Relasjonsnavn {
            PERSON,
            ELEVFORHOLD
    }

    private @Valid Identifikator brukernavn;
    private @Valid Identifikator elevnummer;
    private @Valid Identifikator feidenavn;
    private @Valid Kontaktinformasjon kontaktinformasjon;
    @NotNull
    private @Valid Identifikator systemId;
}
