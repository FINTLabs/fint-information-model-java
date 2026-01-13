package no.novari.fint.model.resource.okonomi.faktura;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.*;

import no.novari.fint.model.resource.FintLinks;
import no.novari.fint.model.FintComplexDatatypeObject;
import no.novari.fint.model.resource.Link;
import no.novari.fint.model.FintIdentifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class FakturalinjeResource implements FintComplexDatatypeObject, FintLinks {
    // Attributes
    @NotNull
    private Float antall;
    private List<String> fritekst;
    @NotNull
    private Long pris;

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getVare() {
        return getLinks().getOrDefault("vare", Collections.emptyList()); 
    }
    public void addVare(Link link) {
        addLink("vare", link);
    }
}
