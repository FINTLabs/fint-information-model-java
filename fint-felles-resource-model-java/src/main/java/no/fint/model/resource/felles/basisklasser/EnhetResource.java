// Built from tag v3.5.0

package no.fint.model.resource.felles.basisklasser;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import no.fint.model.FintAbstractObject;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.Link;
import no.fint.model.resource.felles.kompleksedatatyper.AdresseResource;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.felles.basisklasser.AktorResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public abstract class EnhetResource extends AktorResource implements FintAbstractObject, FintLinks {
    // Attributes
    @JsonIgnore
    @Override
    public List<FintLinks> getNestedResources() {
        List<FintLinks> result = super.getNestedResources();
        if (forretningsadresse != null) {
            result.add(forretningsadresse);
        }
        return result;
    }
    private AdresseResource forretningsadresse;
    private String organisasjonsnavn;
    private Identifikator organisasjonsnummer;

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
}
