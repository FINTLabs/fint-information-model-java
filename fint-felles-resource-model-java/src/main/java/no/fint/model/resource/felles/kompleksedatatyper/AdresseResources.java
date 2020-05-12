// Built from tag v3.5.0

package no.fint.model.resource.felles.kompleksedatatyper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class AdresseResources extends AbstractCollectionResources<AdresseResource> {

    public AdresseResources(Collection<AdresseResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<AdresseResource>> getTypeReference() {
        return new TypeReference<List<AdresseResource>>() {};
    }
}
