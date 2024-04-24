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
import no.fint.model.resource.FintResource;
import no.fint.model.resource.Link;
import no.fint.model.FintIdentifikator;
import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class MerknadResource implements FintResource, FintLinks {
    // Attributes
    @NotNull
    private @Valid Date merknadsdato;
    @NotBlank
    private String merknadstekst;

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getMerknadstype() {
        return getLinks().getOrDefault("merknadstype", Collections.emptyList()); 
    }
    public void addMerknadstype(Link link) {
        addLink("merknadstype", link);
    }
    @JsonIgnore
    public List<Link> getMerknadRegistrertAv() {
        return getLinks().getOrDefault("merknadRegistrertAv", Collections.emptyList()); 
    }
    public void addMerknadRegistrertAv(Link link) {
        addLink("merknadRegistrertAv", link);
    }
}
