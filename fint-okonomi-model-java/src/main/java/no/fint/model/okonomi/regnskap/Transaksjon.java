package no.fint.model.okonomi.regnskap;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.FintMainObject;
import no.fint.model.okonomi.regnskap.Bilag;
import java.util.Date;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Transaksjon implements FintMainObject {
    @Getter
    public enum Relasjonsnavn {
            LEVERANDOR("no.fint.model.okonomi.regnskap.Leverandor", "0..1"),
            ANSVARLIG("no.fint.model.administrasjon.personal.Personalressurs", "0..1"),
            VALUTA("no.fint.model.felles.kodeverk.Valuta", "1"),
            POSTERING("no.fint.model.okonomi.regnskap.Postering", "1..*");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }
    }


	public Map<String, Identifikator> getIdentifikators() {
    	Map<String, Identifikator> identifikators = new HashMap<>();
		identifikators.put("transaksjonsId", this.transaksjonsId);
    
    	return identifikators;
	}


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
