package no.novari.fint.model.resource.utdanning.timeplan;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class EksamenResources extends AbstractCollectionResources<EksamenResource> {

    public EksamenResources(Collection<EksamenResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<EksamenResource>> getTypeReference() {
        return new TypeReference<List<EksamenResource>>() {};
    }
}
