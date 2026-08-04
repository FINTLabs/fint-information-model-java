package no.novari.fint.model.resource.utdanning.vurdering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class OrdensvurderingResources extends AbstractCollectionResources<OrdensvurderingResource> {

    public OrdensvurderingResources(Collection<OrdensvurderingResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<OrdensvurderingResource>> getTypeReference() {
        return new TypeReference<List<OrdensvurderingResource>>() {};
    }
}
