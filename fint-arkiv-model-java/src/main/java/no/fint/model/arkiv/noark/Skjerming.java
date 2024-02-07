package no.fint.model.arkiv.noark;

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
public class Skjerming implements FintComplexDatatypeObject {
    @Getter
    public enum Relasjonsnavn {
            SKJERMINGSHJEMMEL("no.fint.model.arkiv.kodeverk.Skjermingshjemmel", "1"),
            TILGANGSRESTRIKSJON("no.fint.model.arkiv.kodeverk.Tilgangsrestriksjon", "1");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }
    }

}
