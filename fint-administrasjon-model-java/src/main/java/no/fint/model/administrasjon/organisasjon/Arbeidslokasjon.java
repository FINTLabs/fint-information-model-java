package no.fint.model.administrasjon.organisasjon;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.felles.basisklasser.Enhet;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Arbeidslokasjon extends Enhet implements FintMainObject {
    public enum Relasjonsnavn {
            ARBEIDSFORHOLD
    }

    @NotNull
    private @Valid Identifikator lokasjonskode;
    private String lokasjonsnavn;
}
