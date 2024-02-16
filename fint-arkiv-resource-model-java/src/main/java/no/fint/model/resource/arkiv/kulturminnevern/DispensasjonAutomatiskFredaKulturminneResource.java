package no.fint.model.resource.arkiv.kulturminnevern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.*;

import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.FintMainObject;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.Link;
import no.fint.model.resource.felles.kompleksedatatyper.MatrikkelnummerResource;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.arkiv.noark.SaksmappeResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class DispensasjonAutomatiskFredaKulturminneResource extends SaksmappeResource implements FintMainObject, FintLinks {
    // Attributes
    @JsonIgnore
    @Override
    public List<FintLinks> getNestedResources() {
        List<FintLinks> result = super.getNestedResources();
        if (matrikkelnummer != null) {
            result.add(matrikkelnummer);
        }
        return result;
    }
    @NotBlank
    private String kulturminneId;
    @NotNull
    private @Valid MatrikkelnummerResource matrikkelnummer;
    @NotNull
    private @Valid Identifikator soknadsnummer;
    private String tiltak;

    public Map<String, Identifikator> getIdentifikators() {
    	Map<String, Identifikator> identifikators = new HashMap<>();
		identifikators.putAll(super.getIdentifikators());
		identifikators.put("soknadsnummer", this.soknadsnummer);
    
    	return identifikators;
	}

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
}
