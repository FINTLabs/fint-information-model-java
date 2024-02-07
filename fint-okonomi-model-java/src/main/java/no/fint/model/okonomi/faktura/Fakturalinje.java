package no.fint.model.okonomi.faktura;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintComplexDatatypeObject;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Fakturalinje implements FintComplexDatatypeObject {
    @Getter
    public enum Relasjonsnavn {
            VARE("no.fint.model.okonomi.kodeverk.Vare", "1");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }
    }

    @NotNull
    private Float antall;
    private List<String> fritekst;
    @NotNull
    private Long pris;
}
