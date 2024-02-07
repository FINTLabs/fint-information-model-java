package no.fint.model.arkiv.samferdsel;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.arkiv.noark.Saksmappe;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class SoknadDrosjeloyve extends Saksmappe implements FintMainObject {
    @NotBlank
    private String organisasjonsnavn;
    @NotBlank
    private String organisasjonsnummer;
}
