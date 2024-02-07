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
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Fakturautsteder implements FintMainObject {
    @Getter
    public enum Relasjonsnavn {
            ORGANISASJONSELEMENT("no.fint.model.administrasjon.organisasjon.Organisasjonselement", "0..1"),
            FAKTURAGRUNNLAG("no.fint.model.okonomi.faktura.Fakturagrunnlag", "0..*"),
            VARE("no.fint.model.okonomi.kodeverk.Vare", "0..*");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }
    }

    @NotBlank
    private String navn;
    @NotNull
    private @Valid Identifikator systemId;
}
