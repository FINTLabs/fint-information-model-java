package no.fint.model.felles.kodeverk;

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
public class Valuta implements FintMainObject {
    @NotNull
    private @Valid Identifikator bokstavkode;
    @NotBlank
    private String navn;
    @NotNull
    private @Valid Identifikator nummerkode;
}
