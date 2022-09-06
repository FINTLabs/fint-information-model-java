package no.fint.model.resource.utdanning.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class SkolearResources extends AbstractCollectionResources<SkolearResource> {

    public SkolearResources(Collection<SkolearResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<SkolearResource>> getTypeReference() {
        return new TypeReference<List<SkolearResource>>() {};
    }
}
