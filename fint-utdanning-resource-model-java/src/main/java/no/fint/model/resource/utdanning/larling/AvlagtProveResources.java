package no.fint.model.resource.utdanning.larling;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class AvlagtProveResources extends AbstractCollectionResources<AvlagtProveResource> {

    public AvlagtProveResources(Collection<AvlagtProveResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<AvlagtProveResource>> getTypeReference() {
        return new TypeReference<List<AvlagtProveResource>>() {};
    }
}
