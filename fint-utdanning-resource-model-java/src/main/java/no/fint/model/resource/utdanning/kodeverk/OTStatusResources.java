package no.fint.model.resource.utdanning.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class OTStatusResources extends AbstractCollectionResources<OTStatusResource> {

    public OTStatusResources(Collection<OTStatusResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<OTStatusResource>> getTypeReference() {
        return new TypeReference<List<OTStatusResource>>() {};
    }
}
