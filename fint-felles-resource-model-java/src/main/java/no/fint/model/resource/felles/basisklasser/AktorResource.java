package no.fint.model.resource.felles.basisklasser;

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
import no.fint.model.felles.kompleksedatatyper.Kontaktinformasjon;
import no.fint.model.resource.felles.kompleksedatatyper.AdresseResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class AktorResource implements FintResource, FintLinks {
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
