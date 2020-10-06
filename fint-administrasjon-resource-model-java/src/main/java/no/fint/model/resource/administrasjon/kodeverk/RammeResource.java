// Built from tag v3.6.0-rc-1

package no.fint.model.resource.administrasjon.kodeverk;

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
import no.fint.model.administrasjon.kodeverk.Kontodimensjon;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class RammeResource extends Kontodimensjon implements FintMainObject, FintLinks {

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getFullmakt() {
        return getLinks().getOrDefault("fullmakt", Collections.emptyList()); 
    }
    public void addFullmakt(Link link) {
        addLink("fullmakt", link);
    }
}
