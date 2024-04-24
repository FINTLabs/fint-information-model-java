package no.fint.model.resource.utdanning.larling;

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
import no.fint.model.felles.kompleksedatatyper.Periode;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class LarlingResource implements FintResource, FintLinks {
    // Attributes
    private String kontraktstype;
    private @Valid Periode laretid;
    @NotNull
    private @Valid Identifikator systemId;
	@JsonIgnore
	public Map<String, FintIdentifikator> getIdentifikators() {
    	Map<String, FintIdentifikator> identifikators = new HashMap<>();
		identifikators.put("systemId", this.systemId);
    
    	return identifikators;
	}

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getPerson() {
        return getLinks().getOrDefault("person", Collections.emptyList()); 
    }
    public void addPerson(Link link) {
        addLink("person", link);
    }
    @JsonIgnore
    public List<Link> getBedrift() {
        return getLinks().getOrDefault("bedrift", Collections.emptyList()); 
    }
    public void addBedrift(Link link) {
        addLink("bedrift", link);
    }
    @JsonIgnore
    public List<Link> getProgramomrade() {
        return getLinks().getOrDefault("programomrade", Collections.emptyList()); 
    }
    public void addProgramomrade(Link link) {
        addLink("programomrade", link);
    }
}
