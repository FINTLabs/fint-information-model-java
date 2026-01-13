package no.novari.fint.model.resource.felles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class VirksomhetResources extends AbstractCollectionResources<VirksomhetResource> {

    public VirksomhetResources(Collection<VirksomhetResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<VirksomhetResource>> getTypeReference() {
        return new TypeReference<List<VirksomhetResource>>() {};
    }
}
