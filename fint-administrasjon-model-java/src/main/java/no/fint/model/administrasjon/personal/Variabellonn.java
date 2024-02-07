package no.fint.model.administrasjon.personal;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.administrasjon.personal.Lonn;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Variabellonn extends Lonn implements FintMainObject {
    @Getter
    public enum Relasjonsnavn {
            LONNSART("no.fint.model.administrasjon.kodeverk.Lonnsart", "1"),
            ARBEIDSFORHOLD("no.fint.model.administrasjon.personal.Arbeidsforhold", "1");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }
    }

    @NotNull
    private Long antall;
    private Long belop;
}
