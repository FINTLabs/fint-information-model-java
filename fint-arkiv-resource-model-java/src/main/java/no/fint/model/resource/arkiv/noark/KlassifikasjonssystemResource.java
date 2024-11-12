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
import no.fint.model.resource.arkiv.noark.KlasseResource;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class KlassifikasjonssystemResource implements FintResource {
    // Attributes
    @JsonIgnore
    @Override
    public List<FintLinks> getNestedResources() {
        List<FintLinks> result = FintResource.super.getNestedResources();
        if (klasse != null) {
            result.addAll(klasse);
        }
        return result;
    }
    private String avsluttetAv;
    private @Valid Date avsluttetDato;
    private String beskrivelse;
    @NotEmpty
    private List<@Valid KlasseResource> klasse;
    @NotBlank
    private String opprettetAv;
    @NotNull
    private @Valid Date opprettetDato;
    @NotNull
    private @Valid Identifikator systemId;
    @NotBlank
    private String tittel;
    @JsonIgnore
    @Override
    public Map<String, FintIdentifikator> getIdentifikators() {
        Map<String, FintIdentifikator> identifikators = new HashMap<>();
        identifikators.put("systemId", this.systemId);

        return Collections.unmodifiableMap(identifikators);
    }

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getKlassifikasjonstype() {
        return getLinks().getOrDefault("klassifikasjonstype", Collections.emptyList()); 
    }
    public void addKlassifikasjonstype(Link link) {
        addLink("klassifikasjonstype", link);
    }
    @JsonIgnore
    public List<Link> getArkivdel() {
        return getLinks().getOrDefault("arkivdel", Collections.emptyList()); 
    }
    public void addArkivdel(Link link) {
        addLink("arkivdel", link);
    }
}
