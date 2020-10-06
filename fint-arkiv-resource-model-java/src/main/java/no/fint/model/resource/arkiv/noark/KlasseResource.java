// Built from tag v3.6.0-rc-1

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

import no.fint.model.FintComplexDatatypeObject;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.Link;
import no.fint.model.resource.arkiv.noark.SkjermingResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class KlasseResource implements FintComplexDatatypeObject, FintLinks {
    // Attributes
    @JsonIgnore
    @Override
    public List<FintLinks> getNestedResources() {
        List<FintLinks> result = FintLinks.super.getNestedResources();
        if (skjerming != null) {
            result.add(skjerming);
        }
        return result;
    }
    @NotBlank
    private String klasseId;
    private Integer rekkefolge;
    private @Valid SkjermingResource skjerming;
    @NotBlank
    private String tittel;

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getKlassifikasjonssystem() {
        return getLinks().getOrDefault("klassifikasjonssystem", Collections.emptyList()); 
    }
    public void addKlassifikasjonssystem(Link link) {
        addLink("klassifikasjonssystem", link);
    }
}
