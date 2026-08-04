package no.novari.fint.model.resource.utdanning.vurdering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class FagvurderingResources extends AbstractCollectionResources<FagvurderingResource> {

    public FagvurderingResources(Collection<FagvurderingResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<FagvurderingResource>> getTypeReference() {
        return new TypeReference<List<FagvurderingResource>>() {};
    }
}
