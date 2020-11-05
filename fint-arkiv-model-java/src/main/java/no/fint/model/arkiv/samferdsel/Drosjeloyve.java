package no.fint.model.arkiv.samferdsel;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Adresse;
import no.fint.model.felles.kompleksedatatyper.Kontaktinformasjon;
import no.fint.model.arkiv.noark.Saksmappe;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Drosjeloyve extends Saksmappe implements FintMainObject {
    private @Valid Adresse forretningsadresse;
    private @Valid Kontaktinformasjon kontaktinformasjon;
    private String organisasjonsnavn;
    @NotBlank
    private String organisasjonsnummer;
    private String soknadsreferanse;
}
