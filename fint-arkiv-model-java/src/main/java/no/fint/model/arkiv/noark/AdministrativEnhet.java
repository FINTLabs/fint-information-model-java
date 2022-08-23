package no.fint.model.arkiv.noark;

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
public class AdministrativEnhet implements FintMainObject {
    public enum Relasjonsnavn {
            ORGANISASJONSELEMENT
    }

    private @Valid Periode gyldighetsperiode;
    @NotBlank
    private String navn;
    @NotNull
    private @Valid Identifikator systemId;
}
