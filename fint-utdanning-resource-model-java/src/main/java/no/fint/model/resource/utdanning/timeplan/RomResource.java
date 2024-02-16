package no.fint.model.resource.utdanning.timeplan;

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
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class RomResource implements FintMainObject, FintLinks {
    // Attributes
    private String navn;
    @NotNull
    private @Valid Identifikator systemId;

    public Map<String, Identifikator> getIdentifikators() {
    	Map<String, Identifikator> identifikators = new HashMap<>();
		identifikators.put("systemId", this.systemId);
    
    	return identifikators;
	}

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getTime() {
        return getLinks().getOrDefault("time", Collections.emptyList()); 
    }
    public void addTime(Link link) {
        addLink("time", link);
    }
    @JsonIgnore
    public List<Link> getEksamen() {
        return getLinks().getOrDefault("eksamen", Collections.emptyList()); 
    }
    public void addEksamen(Link link) {
        addLink("eksamen", link);
    }
}
