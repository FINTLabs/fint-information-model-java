package no.fint.model.okonomi.regnskap;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.okonomi.regnskap.Bilag;
import java.util.Date;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Transaksjon implements FintMainObject {
    public enum Relasjonsnavn {
            LEVERANDOR,
            ANSVARLIG,
            VALUTA,
            POSTERING
    }

    @NotNull
    private Long belop;
    private String beskrivelse;
    private List<@Valid Bilag> bilag;
    @NotNull
    private Date forfallsdato;
    private Date oppdateringstidspunkt;
    private @Valid Identifikator transaksjonsId;
    private Date transaksjonstidspunkt;
}
