// Built from tag v3.5.0

package no.fint.model.administrasjon.organisasjon;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.NonNull;
import java.util.List;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Periode;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.felles.basisklasser.Enhet;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Organisasjonselement extends Enhet implements FintMainObject {
    public enum Relasjonsnavn {
            ANSVAR,
            LEDER,
            OVERORDNET,
            UNDERORDNET,
            SKOLE,
            ARBEIDSFORHOLD
    }

    private Periode gyldighetsperiode;
    private String kortnavn;
    private String navn;
    @NonNull
    private Identifikator organisasjonsId;
    @NonNull
    private Identifikator organisasjonsKode;
}
