package no.fint.model.resource.utdanning.vurdering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class SluttordensvurderingResources extends AbstractCollectionResources<SluttordensvurderingResource> {

    public SluttordensvurderingResources(Collection<SluttordensvurderingResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<SluttordensvurderingResource>> getTypeReference() {
        return new TypeReference<List<SluttordensvurderingResource>>() {};
    }
}
