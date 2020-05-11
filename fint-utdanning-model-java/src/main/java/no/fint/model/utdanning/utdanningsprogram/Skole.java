// Built from tag v3.5.0

package no.fint.model.utdanning.utdanningsprogram;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.NonNull;
import java.util.List;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.felles.basisklasser.Enhet;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Skole extends Enhet implements FintMainObject {
    public enum Relasjonsnavn {
            ORGANISASJON,
            FAG,
            SKOLEEIERTYPE,
            VIGOREFERANSE,
            BASISGRUPPE,
            ELEVFORHOLD,
            KONTAKTLARERGRUPPE,
            SKOLERESSURS,
            UNDERVISNINGSFORHOLD,
            UNDERVISNINGSGRUPPE,
            EKSAMENSGRUPPE,
            UTDANNINGSPROGRAM
    }

    private String domenenavn;
    private String juridiskNavn;
    @NonNull
    private String navn;
    @NonNull
    private Identifikator skolenummer;
    @NonNull
    private Identifikator systemId;
}
