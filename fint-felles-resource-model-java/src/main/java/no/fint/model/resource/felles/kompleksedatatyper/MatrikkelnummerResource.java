// Built from tag v3.6.0-rc-1

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
public class MatrikkelnummerResource implements FintComplexDatatypeObject, FintLinks {
    // Attributes
    private String bruksnummer;
    private String festenummer;
    private String gardsnummer;
    private String seksjonsnummer;

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getKommunenummer() {
        return getLinks().getOrDefault("kommunenummer", Collections.emptyList()); 
    }
    public void addKommunenummer(Link link) {
        addLink("kommunenummer", link);
    }
}
