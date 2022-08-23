package no.fint.model.resource.arkiv.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class TilknyttetRegistreringSomResources extends AbstractCollectionResources<TilknyttetRegistreringSomResource> {

    public TilknyttetRegistreringSomResources(Collection<TilknyttetRegistreringSomResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<TilknyttetRegistreringSomResource>> getTypeReference() {
        return new TypeReference<List<TilknyttetRegistreringSomResource>>() {};
    }
}
