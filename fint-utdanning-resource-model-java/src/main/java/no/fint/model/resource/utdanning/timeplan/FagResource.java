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
import java.util.HashMap;
import javax.validation.Valid;
import javax.validation.constraints.*;

import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.FintLinks;
import no.fint.model.FintResource;
import no.fint.model.resource.Link;
import no.fint.model.FintIdentifikator;
import no.fint.model.resource.utdanning.basisklasser.GruppeResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class FagResource extends GruppeResource implements FintResource, FintLinks {
	@JsonIgnore
	public Map<String, FintIdentifikator> getIdentifikators() {
    	Map<String, FintIdentifikator> identifikators = new HashMap<>();
		identifikators.putAll(super.getIdentifikators());
    
    	return identifikators;
	}

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getProgramomrade() {
        return getLinks().getOrDefault("programomrade", Collections.emptyList()); 
    }
    public void addProgramomrade(Link link) {
        addLink("programomrade", link);
    }
    @JsonIgnore
    public List<Link> getTilrettelegging() {
        return getLinks().getOrDefault("tilrettelegging", Collections.emptyList()); 
    }
    public void addTilrettelegging(Link link) {
        addLink("tilrettelegging", link);
    }
    @JsonIgnore
    public List<Link> getFaggruppe() {
        return getLinks().getOrDefault("faggruppe", Collections.emptyList()); 
    }
    public void addFaggruppe(Link link) {
        addLink("faggruppe", link);
    }
    @JsonIgnore
    public List<Link> getSkole() {
        return getLinks().getOrDefault("skole", Collections.emptyList()); 
    }
    public void addSkole(Link link) {
        addLink("skole", link);
    }
    @JsonIgnore
    public List<Link> getUndervisningsgruppe() {
        return getLinks().getOrDefault("undervisningsgruppe", Collections.emptyList()); 
    }
    public void addUndervisningsgruppe(Link link) {
        addLink("undervisningsgruppe", link);
    }
    @JsonIgnore
    public List<Link> getEksamensgruppe() {
        return getLinks().getOrDefault("eksamensgruppe", Collections.emptyList()); 
    }
    public void addEksamensgruppe(Link link) {
        addLink("eksamensgruppe", link);
    }
}
