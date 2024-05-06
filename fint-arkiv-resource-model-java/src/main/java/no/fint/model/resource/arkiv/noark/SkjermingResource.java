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
import java.util.HashMap;
import javax.validation.Valid;
import javax.validation.constraints.*;

import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.FintLinks;
import no.fint.model.FintComplexDatatypeObject;
import no.fint.model.resource.Link;
import no.fint.model.FintIdentifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class SkjermingResource implements FintComplexDatatypeObject, FintLinks {

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
