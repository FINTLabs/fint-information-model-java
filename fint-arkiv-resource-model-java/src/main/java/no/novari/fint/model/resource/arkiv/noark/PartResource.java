package no.novari.fint.model.resource.arkiv.noark;

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

import no.fint.model.resource.FintLinks;
import no.fint.model.FintComplexDatatypeObject;
import no.fint.model.resource.Link;
import no.fint.model.FintIdentifikator;
import no.novari.fint.model.resource.felles.kompleksedatatyper.AdresseResource;
import no.novari.fint.model.felles.kompleksedatatyper.Kontaktinformasjon;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PartResource implements FintComplexDatatypeObject, FintLinks {
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
    private String fodselsnummer;
    private @Valid Kontaktinformasjon kontaktinformasjon;
    private String kontaktperson;
    private String organisasjonsnummer;
    @NotBlank
    private String partNavn;

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getPartRolle() {
        return getLinks().getOrDefault("partRolle", Collections.emptyList()); 
    }
    public void addPartRolle(Link link) {
        addLink("partRolle", link);
    }
}
