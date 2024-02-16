package no.fint.model.felles.kompleksedatatyper;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.FintComplexDatatypeObject;
import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Periode implements FintComplexDatatypeObject {

	public Map<String, Identifikator> getIdentifikators() {
    	Map<String, Identifikator> identifikators = new HashMap<>();
    
    	return identifikators;
	}


    private String beskrivelse;
    private @Valid Date slutt;
    @NotNull
    private @Valid Date start;
}
