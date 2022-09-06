package no.fint.model.resource.administrasjon.personal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class FasttilleggResources extends AbstractCollectionResources<FasttilleggResource> {

    public FasttilleggResources(Collection<FasttilleggResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<FasttilleggResource>> getTypeReference() {
        return new TypeReference<List<FasttilleggResource>>() {};
    }
}
