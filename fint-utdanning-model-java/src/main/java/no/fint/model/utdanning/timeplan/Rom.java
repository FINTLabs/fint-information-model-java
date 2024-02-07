package no.fint.model.utdanning.timeplan;

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
public class Rom implements FintMainObject {
    @Getter
    public enum Relasjonsnavn {
            TIME("no.fint.model.utdanning.timeplan.Time", "0..*"),
            EKSAMEN("no.fint.model.utdanning.timeplan.Eksamen", "0..*");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }
    }

    private String navn;
    @NotNull
    private @Valid Identifikator systemId;
}
