package no.fint.model.arkiv.kulturminnevern;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.arkiv.noark.Saksmappe;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class TilskuddFartoy extends Saksmappe implements FintMainObject {
    @NotBlank
    private String fartoyNavn;
    @NotBlank
    private String kallesignal;
    @NotBlank
    private String kulturminneId;
    @NotNull
    private @Valid Identifikator soknadsnummer;
}
