package no.fint.model.felles.kodeverk;

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
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Valuta implements FintMainObject {

	public Map<String, Identifikator> getIdentifikators() {
    	Map<String, Identifikator> identifikators = new HashMap<>();
		identifikators.put("bokstavkode", this.bokstavkode);
		identifikators.put("nummerkode", this.nummerkode);
    
    	return identifikators;
	}


    @NotNull
    private @Valid Identifikator bokstavkode;
    @NotBlank
    private String navn;
    @NotNull
    private @Valid Identifikator nummerkode;
}
