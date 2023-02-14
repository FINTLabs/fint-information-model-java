package no.fint.model.okonomi.regnskap;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.administrasjon.kompleksedatatyper.Kontostreng;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Postering implements FintMainObject {
    public enum Relasjonsnavn {
            TRANSAKSJON
    }

    @NotNull
    private Long belop;
    @NotNull
    private Boolean debet;
    @NotNull
    private @Valid Kontostreng kontering;
    @NotNull
    private @Valid Identifikator posteringsId;
}
