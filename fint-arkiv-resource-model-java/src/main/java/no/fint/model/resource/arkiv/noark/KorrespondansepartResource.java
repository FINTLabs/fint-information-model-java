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
import no.fint.model.FintResource;
import no.fint.model.resource.Link;
import no.fint.model.FintIdentifikator;
import no.fint.model.resource.felles.kompleksedatatyper.AdresseResource;
import no.fint.model.felles.kompleksedatatyper.Kontaktinformasjon;
import no.fint.model.resource.arkiv.noark.SkjermingResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class KorrespondansepartResource implements FintResource, FintLinks {
    // Attributes
    @JsonIgnore
    @Override
    public List<FintLinks> getNestedResources() {
        List<FintLinks> result = FintLinks.super.getNestedResources();
        if (adresse != null) {
            result.add(adresse);
        }
        if (skjerming != null) {
            result.add(skjerming);
        }
        return result;
    }
    private @Valid AdresseResource adresse;
    private String fodselsnummer;
    private @Valid Kontaktinformasjon kontaktinformasjon;
    private String kontaktperson;
    private String korrespondansepartNavn;
    private String organisasjonsnummer;
    private @Valid SkjermingResource skjerming;

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getKorrespondanseparttype() {
        return getLinks().getOrDefault("korrespondanseparttype", Collections.emptyList()); 
    }
    public void addKorrespondanseparttype(Link link) {
        addLink("korrespondanseparttype", link);
    }
}
