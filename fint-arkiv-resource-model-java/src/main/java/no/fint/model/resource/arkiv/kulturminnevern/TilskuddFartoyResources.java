package no.fint.model.resource.arkiv.kulturminnevern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class TilskuddFartoyResources extends AbstractCollectionResources<TilskuddFartoyResource> {

    public TilskuddFartoyResources(Collection<TilskuddFartoyResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<TilskuddFartoyResource>> getTypeReference() {
        return new TypeReference<List<TilskuddFartoyResource>>() {};
    }
}
