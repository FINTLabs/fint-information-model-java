package no.novari.fint.model.resource.arkiv.noark;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class TilgangResources extends AbstractCollectionResources<TilgangResource> {

    public TilgangResources(Collection<TilgangResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<TilgangResource>> getTypeReference() {
        return new TypeReference<List<TilgangResource>>() {};
    }
}
