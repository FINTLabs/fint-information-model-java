// Built from tag v3.6.0-rc-1

package no.fint.model.arkiv.noark;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Arkivdel implements FintMainObject {
    public enum Relasjonsnavn {
            KLASSIFIKASJONSSYSTEM,
            REGISTRERING,
            MAPPE
    }

    @NotNull
    private @Valid Identifikator systemId;
    @NotBlank
    private String tittel;
}
