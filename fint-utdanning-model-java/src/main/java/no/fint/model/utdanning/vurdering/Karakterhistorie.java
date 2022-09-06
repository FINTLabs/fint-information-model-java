package no.fint.model.utdanning.vurdering;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import java.util.Date;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Karakterhistorie implements FintMainObject {
    public enum Relasjonsnavn {
            OPPDATERTAV,
            OPPRINNELIGKARAKTERVERDI,
            OPPRINNELIGKARAKTERSTATUS,
            KARAKTERVERDI,
            KARAKTERSTATUS
    }

    @NotNull
    private @Valid Date endretDato;
    @NotNull
    private @Valid Identifikator systemId;
}
