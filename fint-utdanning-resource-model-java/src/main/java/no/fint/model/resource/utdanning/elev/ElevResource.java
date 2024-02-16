package no.fint.model.resource.utdanning.elev;

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
import no.fint.model.resource.felles.kompleksedatatyper.AdresseResource;
import no.fint.model.felles.kompleksedatatyper.Kontaktinformasjon;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ElevResource implements FintMainObject, FintLinks {
    // Attributes
    @JsonIgnore
    @Override
    public List<FintLinks> getNestedResources() {
        List<FintLinks> result = FintLinks.super.getNestedResources();
        if (hybeladresse != null) {
            result.add(hybeladresse);
        }
        return result;
    }
    private @Valid Identifikator brukernavn;
    private @Valid Identifikator elevnummer;
    private @Valid Identifikator feidenavn;
    private Boolean gjest;
    private @Valid AdresseResource hybeladresse;
    private @Valid Kontaktinformasjon kontaktinformasjon;
    @NotNull
    private @Valid Identifikator systemId;

    public Map<String, Identifikator> getIdentifikators() {
    	Map<String, Identifikator> identifikators = new HashMap<>();
		identifikators.put("brukernavn", this.brukernavn);
		identifikators.put("elevnummer", this.elevnummer);
		identifikators.put("feidenavn", this.feidenavn);
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
    public List<Link> getElevforhold() {
        return getLinks().getOrDefault("elevforhold", Collections.emptyList()); 
    }
    public void addElevforhold(Link link) {
        addLink("elevforhold", link);
    }
}
