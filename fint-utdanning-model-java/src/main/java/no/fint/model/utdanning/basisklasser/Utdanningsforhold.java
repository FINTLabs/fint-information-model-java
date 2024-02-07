package no.fint.model.utdanning.basisklasser;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintAbstractObject;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class Utdanningsforhold implements FintAbstractObject {
    @Getter
    public enum Relasjonsnavn {
            MEDLEMSKAP("no.fint.model.utdanning.elev.Medlemskap", "0..*");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }
    }

    @NotBlank
    private String beskrivelse;
    @NotNull
    private @Valid Identifikator systemId;
}
