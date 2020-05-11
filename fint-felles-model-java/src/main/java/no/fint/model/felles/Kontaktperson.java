// Built from tag v3.5.0

package no.fint.model.felles;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.NonNull;
import java.util.List;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Kontaktinformasjon;
import no.fint.model.felles.kompleksedatatyper.Personnavn;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Kontaktperson implements FintMainObject {
    public enum Relasjonsnavn {
            KONTAKTPERSON,
            PERSON
    }

    @Deprecated
    @NonNull
    private Boolean foreldreansvar;
    private Kontaktinformasjon kontaktinformasjon;
    private Personnavn navn;
    @NonNull
    private Identifikator systemId;
    @NonNull
    private String type;
}
