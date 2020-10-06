// Built from tag v3.6.0-rc-1

package no.fint.model.arkiv.noark;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintComplexDatatypeObject;
import no.fint.model.arkiv.noark.Skjerming;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Klasse implements FintComplexDatatypeObject {
    public enum Relasjonsnavn {
            KLASSIFIKASJONSSYSTEM
    }

    @NotBlank
    private String klasseId;
    private Integer rekkefolge;
    private @Valid Skjerming skjerming;
    @NotBlank
    private String tittel;
}
