package no.fint.model.resource.arkiv.noark;

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
import no.fint.model.FintComplexDatatypeObject;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.Link;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class SkjermingResource implements FintComplexDatatypeObject, FintLinks {

    public Map<String, Identifikator> getIdentifikators() {
    	Map<String, Identifikator> identifikators = new HashMap<>();
    
    	return identifikators;
	}

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getSkjermingshjemmel() {
        return getLinks().getOrDefault("skjermingshjemmel", Collections.emptyList()); 
    }
    public void addSkjermingshjemmel(Link link) {
        addLink("skjermingshjemmel", link);
    }
    @JsonIgnore
    public List<Link> getTilgangsrestriksjon() {
        return getLinks().getOrDefault("tilgangsrestriksjon", Collections.emptyList()); 
    }
    public void addTilgangsrestriksjon(Link link) {
        addLink("tilgangsrestriksjon", link);
    }
}
