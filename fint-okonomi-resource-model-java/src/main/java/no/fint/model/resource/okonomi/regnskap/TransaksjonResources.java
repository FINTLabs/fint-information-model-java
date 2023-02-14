package no.fint.model.resource.okonomi.regnskap;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class TransaksjonResources extends AbstractCollectionResources<TransaksjonResource> {

    public TransaksjonResources(Collection<TransaksjonResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<TransaksjonResource>> getTypeReference() {
        return new TypeReference<List<TransaksjonResource>>() {};
    }
}
