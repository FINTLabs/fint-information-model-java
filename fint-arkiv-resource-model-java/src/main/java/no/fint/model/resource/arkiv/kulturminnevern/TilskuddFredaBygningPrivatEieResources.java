// Built from tag v3.6.0-rc-1

package no.fint.model.resource.arkiv.kulturminnevern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class TilskuddFredaBygningPrivatEieResources extends AbstractCollectionResources<TilskuddFredaBygningPrivatEieResource> {

    public TilskuddFredaBygningPrivatEieResources(Collection<TilskuddFredaBygningPrivatEieResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<TilskuddFredaBygningPrivatEieResource>> getTypeReference() {
        return new TypeReference<List<TilskuddFredaBygningPrivatEieResource>>() {};
    }
}
