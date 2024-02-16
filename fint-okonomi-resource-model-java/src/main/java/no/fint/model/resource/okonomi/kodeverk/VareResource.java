package no.fint.model.resource.okonomi.kodeverk;

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
import no.fint.model.resource.administrasjon.kompleksedatatyper.KontostrengResource;
import no.fint.model.felles.basisklasser.Begrep;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class VareResource extends Begrep implements FintMainObject, FintLinks {
    // Attributes
    @JsonIgnore
    @Override
    public List<FintLinks> getNestedResources() {
        List<FintLinks> result = FintLinks.super.getNestedResources();
        if (kontering != null) {
            result.add(kontering);
        }
        return result;
    }
    @NotBlank
    private String enhet;
    private @Valid KontostrengResource kontering;
    @NotNull
    private Long pris;

    public Map<String, Identifikator> getIdentifikators() {
    	Map<String, Identifikator> identifikators = new HashMap<>();
		identifikators.putAll(super.getIdentifikators());
    
    	return identifikators;
	}

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getFakturautsteder() {
        return getLinks().getOrDefault("fakturautsteder", Collections.emptyList()); 
    }
    public void addFakturautsteder(Link link) {
        addLink("fakturautsteder", link);
    }
    @JsonIgnore
    public List<Link> getMerverdiavgift() {
        return getLinks().getOrDefault("merverdiavgift", Collections.emptyList()); 
    }
    public void addMerverdiavgift(Link link) {
        addLink("merverdiavgift", link);
    }
}
