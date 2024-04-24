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
import java.util.HashMap;
import javax.validation.Valid;
import javax.validation.constraints.*;

import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.FintLinks;
import no.fint.model.FintResource;
import no.fint.model.resource.Link;
import no.fint.model.FintIdentifikator;
import no.fint.model.resource.felles.kompleksedatatyper.AdresseResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class MatrikkelnummerResource implements FintResource, FintLinks {
    // Attributes
    @JsonIgnore
    @Override
    public List<FintLinks> getNestedResources() {
        List<FintLinks> result = FintLinks.super.getNestedResources();
        if (adresse != null) {
            result.add(adresse);
        }
        return result;
    }
    private @Valid AdresseResource adresse;
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
