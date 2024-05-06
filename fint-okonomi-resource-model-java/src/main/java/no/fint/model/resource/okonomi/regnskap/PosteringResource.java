package no.fint.model.resource.okonomi.regnskap;

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
import no.fint.model.FintResourceObject;
import no.fint.model.resource.Link;
import no.fint.model.FintIdentifikator;
import no.fint.model.resource.administrasjon.kompleksedatatyper.KontostrengResource;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PosteringResource implements FintResourceObject, FintLinks {
    // Attributes
    @JsonIgnore
    @Override
    public List<FintLinks> getNestedResources() {
        List<FintLinks> result = FintLinks.super.getNestedResources();
        if (kontering != null) {
            result.add(kontering);
        }
        return result;
    }
    @NotNull
    private Long belop;
    @NotNull
    private Boolean debet;
    @NotNull
    private @Valid KontostrengResource kontering;
    @NotNull
    private @Valid Identifikator posteringsId;
    @JsonIgnore
    public Map<String, FintIdentifikator> getIdentifikators() {
        Map<String, FintIdentifikator> identifikators = new HashMap<>();
        identifikators.put("posteringsId", this.posteringsId);
    
        return identifikators;
    }

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getTransaksjon() {
        return getLinks().getOrDefault("transaksjon", Collections.emptyList()); 
    }
    public void addTransaksjon(Link link) {
        addLink("transaksjon", link);
    }
}
