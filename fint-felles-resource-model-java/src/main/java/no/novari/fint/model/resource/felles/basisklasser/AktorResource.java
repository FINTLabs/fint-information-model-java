package no.novari.fint.model.resource.felles.basisklasser;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import no.fint.model.resource.FintLinks;
import no.fint.model.FintAbstractObject;
import no.fint.model.resource.Link;
import no.fint.model.FintIdentifikator;
import no.novari.fint.model.felles.kompleksedatatyper.Kontaktinformasjon;
import no.novari.fint.model.resource.felles.kompleksedatatyper.AdresseResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class AktorResource implements FintAbstractObject, FintLinks {
    // Attributes
    @JsonIgnore
    @Override
    public List<FintLinks> getNestedResources() {
        List<FintLinks> result = FintLinks.super.getNestedResources();
        if (postadresse != null) {
            result.add(postadresse);
        }
        return result;
    }
    private @Valid Kontaktinformasjon kontaktinformasjon;
    private @Valid AdresseResource postadresse;

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
}
