// Built from tag v3.6.0-rc-1

package no.fint.model.resource.administrasjon.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class ArtResources extends AbstractCollectionResources<ArtResource> {

    public ArtResources(Collection<ArtResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<ArtResource>> getTypeReference() {
        return new TypeReference<List<ArtResource>>() {};
    }
}
