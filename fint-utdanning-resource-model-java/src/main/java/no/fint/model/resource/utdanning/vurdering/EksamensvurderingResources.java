package no.fint.model.resource.utdanning.vurdering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class EksamensvurderingResources extends AbstractCollectionResources<EksamensvurderingResource> {

    public EksamensvurderingResources(Collection<EksamensvurderingResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<EksamensvurderingResource>> getTypeReference() {
        return new TypeReference<List<EksamensvurderingResource>>() {};
    }
}
