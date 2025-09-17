package no.novari.fint.model.resource.utdanning.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class AvbruddsarsakResources extends AbstractCollectionResources<AvbruddsarsakResource> {

    public AvbruddsarsakResources(Collection<AvbruddsarsakResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<AvbruddsarsakResource>> getTypeReference() {
        return new TypeReference<List<AvbruddsarsakResource>>() {};
    }
}
