// Built from tag v3.6.0-rc-1

package no.fint.model.okonomi.faktura;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.okonomi.faktura.Fakturalinje;
import java.util.Date;
import no.fint.model.okonomi.faktura.Fakturamottaker;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Fakturagrunnlag implements FintMainObject {
    public enum Relasjonsnavn {
            FAKTURA,
            FAKTURAUTSTEDER
    }

    private Long avgiftsbelop;
    @NotEmpty
    private List<@Valid Fakturalinje> fakturalinjer;
    private Date leveringsdato;
    @NotNull
    private @Valid Fakturamottaker mottaker;
    private Long nettobelop;
    @NotNull
    private @Valid Identifikator ordrenummer;
    private Long totalbelop;
}
