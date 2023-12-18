package no.fint.model.arkiv.noark;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintComplexDatatypeObject;
import no.fint.model.arkiv.noark.Skjerming;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Klasse implements FintComplexDatatypeObject {
    public enum Relasjonsnavn {
            KLASSIFIKASJONSSYSTEM("no.fint.model.arkiv.noark.Klassifikasjonssystem", "1");
	
		private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }

        public String getTypeName() {
            return typeName;
        }

        public String getMultiplicity() {
            return multiplicity;
        }
    }

    @NotBlank
    private String klasseId;
    private Integer rekkefolge;
    private @Valid Skjerming skjerming;
    @NotBlank
    private String tittel;
}
