package no.fint.model.resource.arkiv.noark;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class SkjermingResources extends AbstractCollectionResources<SkjermingResource> {

    public SkjermingResources(Collection<SkjermingResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<SkjermingResource>> getTypeReference() {
        return new TypeReference<List<SkjermingResource>>() {};
    }
}
