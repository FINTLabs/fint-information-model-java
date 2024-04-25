package no.fint.model.okonomi.faktura;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMultiplicity;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.FintMetaObject;
import no.fint.model.FintIdentifikator;
import no.fint.model.FintRelation;
import no.fint.model.okonomi.faktura.Fakturalinje;
import java.util.Date;
import no.fint.model.okonomi.faktura.Fakturamottaker;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

import static no.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Fakturagrunnlag  implements FintMetaObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
            FAKTURA("faktura", "no.fint.model.okonomi.faktura.Faktura", NONE_TO_MANY),
            FAKTURAUTSTEDER("fakturautsteder", "no.fint.model.okonomi.faktura.Fakturautsteder", ONE_TO_ONE);
	
		private final String name;
        private final String packageName;
        private final FintMultiplicity multiplicity;

        private Relasjonsnavn(String name, String packageName, FintMultiplicity multiplicity) {
			this.name = name;
            this.packageName = packageName;
            this.multiplicity = multiplicity;
        }
    }

	@JsonIgnore
	public Map<String, FintIdentifikator> getIdentifikators() {
    	Map<String, FintIdentifikator> identifikators = new HashMap<>();
		identifikators.put("ordrenummer", this.ordrenummer);
    
    	return identifikators;
	}
	@JsonIgnore
	private final List<FintRelation> relations = new ArrayList<>(Arrays.asList(Relasjonsnavn.values()));
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
