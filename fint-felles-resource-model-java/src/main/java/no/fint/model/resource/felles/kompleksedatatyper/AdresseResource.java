// Built from tag v3.5.0

package no.fint.model.resource.felles.kompleksedatatyper;

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

import no.fint.model.FintComplexDatatypeObject;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.Link;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AdresseResource implements FintComplexDatatypeObject, FintLinks {
    // Attributes
    private List<String> adresselinje;
    private String postnummer;
    private String poststed;

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getLand() {
        return getLinks().getOrDefault("land", Collections.emptyList()); 
    }
    public void addLand(Link link) {
        addLink("land", link);
    }
}
