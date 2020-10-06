package no.fint.model.felles.kompleksedatatyper;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintComplexDatatypeObject;
import no.fint.model.felles.kompleksedatatyper.Periode;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Identifikator implements FintComplexDatatypeObject {
    private @Valid Periode gyldighetsperiode;
    @NotBlank
    private String identifikatorverdi;
}
