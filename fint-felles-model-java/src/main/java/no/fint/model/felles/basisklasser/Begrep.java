// Built from tag v3.6.0-rc-2

package no.fint.model.felles.basisklasser;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintAbstractObject;
import no.fint.model.felles.kompleksedatatyper.Periode;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class Begrep implements FintAbstractObject {
    private @Valid Periode gyldighetsperiode;
    @NotBlank
    private String kode;
    @NotBlank
    private String navn;
    private Boolean passiv;
    @NotNull
    private @Valid Identifikator systemId;
}
