// Built from tag v3.6.0-rc-1

package no.fint.model.utdanning.basisklasser;

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
public abstract class Gruppe implements FintAbstractObject {
    @NotBlank
    private String beskrivelse;
    @NotBlank
    private String navn;
    @Deprecated
    private List<@Valid Periode> periode;
    @NotNull
    private @Valid Identifikator systemId;
}
