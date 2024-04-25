package no.fint.model.okonomi.regnskap;

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
import no.fint.model.okonomi.regnskap.Bilag;
import java.util.Date;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

import static no.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Transaksjon  implements FintMetaObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
            LEVERANDOR("leverandor", "no.fint.model.okonomi.regnskap.Leverandor", NONE_TO_ONE),
            ANSVARLIG("ansvarlig", "no.fint.model.administrasjon.personal.Personalressurs", NONE_TO_ONE),
            VALUTA("valuta", "no.fint.model.felles.kodeverk.Valuta", ONE_TO_ONE),
            POSTERING("postering", "no.fint.model.okonomi.regnskap.Postering", ONE_TO_MANY);
	
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
		identifikators.put("transaksjonsId", this.transaksjonsId);
    
    	return identifikators;
	}
	@JsonIgnore
	private final List<FintRelation> relations = new ArrayList<>(Arrays.asList(Relasjonsnavn.values()));
    @NotNull
    private Long belop;
    private String beskrivelse;
    private List<@Valid Bilag> bilag;
    @NotNull
    private Date forfallsdato;
    private Date oppdateringstidspunkt;
    private @Valid Identifikator transaksjonsId;
    private Date transaksjonstidspunkt;
}
