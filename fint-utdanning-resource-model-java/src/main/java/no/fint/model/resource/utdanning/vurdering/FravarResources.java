// Built from tag v3.5.0

package no.fint.model.resource.utdanning.vurdering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class FravarResources extends AbstractCollectionResources<FravarResource> {

    public FravarResources(Collection<FravarResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<FravarResource>> getTypeReference() {
        return new TypeReference<List<FravarResource>>() {};
    }
}
