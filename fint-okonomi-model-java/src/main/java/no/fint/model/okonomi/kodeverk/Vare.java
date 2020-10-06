package no.fint.model.okonomi.kodeverk;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.administrasjon.kompleksedatatyper.Kontostreng;
import no.fint.model.felles.basisklasser.Begrep;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Vare extends Begrep implements FintMainObject {
    public enum Relasjonsnavn {
            FAKTURAUTSTEDER,
            MERVERDIAVGIFT
    }

    @NotBlank
    private String enhet;
    private @Valid Kontostreng kontering;
    @NotNull
    private Long pris;
}
