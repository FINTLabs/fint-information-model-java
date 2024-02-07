package no.fint.model.okonomi.regnskap;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
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
    @Getter
    public enum Relasjonsnavn {
            TRANSAKSJON("no.fint.model.okonomi.regnskap.Transaksjon", "0..1");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }
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
