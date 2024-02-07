package no.fint.model.okonomi.faktura;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
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
    @Getter
    public enum Relasjonsnavn {
            FAKTURA("no.fint.model.okonomi.faktura.Faktura", "0..*"),
            FAKTURAUTSTEDER("no.fint.model.okonomi.faktura.Fakturautsteder", "1");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }
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
