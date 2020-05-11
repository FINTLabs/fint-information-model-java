// Built from tag v3.5.0

package no.fint.model.resource.felles.kodeverk.iso;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class LandkodeResources extends AbstractCollectionResources<LandkodeResource> {

    public LandkodeResources(Collection<LandkodeResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<LandkodeResource>> getTypeReference() {
        return new TypeReference<List<LandkodeResource>>() {};
    }
}
