package no.fint.model.resource.utdanning.vurdering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class FravarsregistreringResources extends AbstractCollectionResources<FravarsregistreringResource> {

    public FravarsregistreringResources(Collection<FravarsregistreringResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<FravarsregistreringResource>> getTypeReference() {
        return new TypeReference<List<FravarsregistreringResource>>() {};
    }
}
