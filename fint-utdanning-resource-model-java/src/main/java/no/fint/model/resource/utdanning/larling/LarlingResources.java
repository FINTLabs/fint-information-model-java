package no.fint.model.resource.utdanning.larling;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class LarlingResources extends AbstractCollectionResources<LarlingResource> {

    public LarlingResources(Collection<LarlingResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<LarlingResource>> getTypeReference() {
        return new TypeReference<List<LarlingResource>>() {};
    }
}
