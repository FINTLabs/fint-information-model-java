package no.fint.model.resource.felles.basisklasser;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.validation.Valid;
import javax.validation.constraints.*;

import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.FintLinks;
import no.fint.model.FintResource;
import no.fint.model.resource.Link;
import no.fint.model.FintIdentifikator;
import no.fint.model.resource.felles.kompleksedatatyper.AdresseResource;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.felles.basisklasser.AktorResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public abstract class EnhetResource extends AktorResource implements FintResource, FintLinks {
    // Attributes
    @JsonIgnore
    @Override
    public List<FintLinks> getNestedResources() {
        List<FintLinks> result = super.getNestedResources();
        if (forretningsadresse != null) {
            result.add(forretningsadresse);
        }
        return result;
    }
    private @Valid AdresseResource forretningsadresse;
    private String organisasjonsnavn;
    private @Valid Identifikator organisasjonsnummer;
	@JsonIgnore
	public Map<String, FintIdentifikator> getIdentifikators() {
    	Map<String, FintIdentifikator> identifikators = new HashMap<>();
		identifikators.put("organisasjonsnummer", this.organisasjonsnummer);
    
    	return identifikators;
	}

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
}
