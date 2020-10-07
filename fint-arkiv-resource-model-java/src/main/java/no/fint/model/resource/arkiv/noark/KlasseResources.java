package no.fint.model.resource.arkiv.noark;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class KlasseResources extends AbstractCollectionResources<KlasseResource> {

    public KlasseResources(Collection<KlasseResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<KlasseResource>> getTypeReference() {
        return new TypeReference<List<KlasseResource>>() {};
    }
}