package no.fint.model.resource.felles;

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
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.felles.basisklasser.EnhetResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class VirksomhetResource extends EnhetResource implements FintMainObject, FintLinks {
    // Attributes
    @NotNull
    private @Valid Identifikator virksomhetsId;

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getLarling() {
        return getLinks().getOrDefault("larling", Collections.emptyList()); 
    }
    public void addLarling(Link link) {
        addLink("larling", link);
    }
}
