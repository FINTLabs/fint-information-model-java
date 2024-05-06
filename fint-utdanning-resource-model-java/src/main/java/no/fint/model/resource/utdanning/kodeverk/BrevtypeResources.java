package no.fint.model.resource.utdanning.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class BrevtypeResources extends AbstractCollectionResources<BrevtypeResource> {

    public BrevtypeResources(Collection<BrevtypeResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<BrevtypeResource>> getTypeReference() {
        return new TypeReference<List<BrevtypeResource>>() {};
    }
}
