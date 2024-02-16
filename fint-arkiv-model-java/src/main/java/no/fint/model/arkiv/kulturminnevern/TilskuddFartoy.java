package no.fint.model.arkiv.kulturminnevern;

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
import no.fint.model.arkiv.noark.Saksmappe;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class TilskuddFartoy extends Saksmappe implements FintMainObject {

	public Map<String, Identifikator> getIdentifikators() {
    	Map<String, Identifikator> identifikators = new HashMap<>();
		identifikators.putAll(super.getIdentifikators());
		identifikators.put("soknadsnummer", this.soknadsnummer);
    
    	return identifikators;
	}


    @NotBlank
    private String fartoyNavn;
    @NotBlank
    private String kallesignal;
    @NotBlank
    private String kulturminneId;
    @NotNull
    private @Valid Identifikator soknadsnummer;
}
