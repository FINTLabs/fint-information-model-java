// Built from tag v3.5.0

package no.fint.model.resource.utdanning.kodeverk;

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

import no.fint.model.FintMainObject;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.Link;
import no.fint.model.felles.basisklasser.Begrep;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class KarakterskalaResource extends Begrep implements FintMainObject, FintLinks {

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getVigoreferanse() {
        return getLinks().getOrDefault("vigoreferanse", Collections.emptyList()); 
    }
    public void addVigoreferanse(Link link) {
        addLink("vigoreferanse", link);
    }
    @JsonIgnore
    public List<Link> getVerdi() {
        return getLinks().getOrDefault("verdi", Collections.emptyList()); 
    }
    public void addVerdi(Link link) {
        addLink("verdi", link);
    }
}
