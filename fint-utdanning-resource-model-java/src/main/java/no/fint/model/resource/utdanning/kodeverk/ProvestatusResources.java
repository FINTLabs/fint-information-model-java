package no.fint.model.resource.utdanning.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class ProvestatusResources extends AbstractCollectionResources<ProvestatusResource> {

    public ProvestatusResources(Collection<ProvestatusResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<ProvestatusResource>> getTypeReference() {
        return new TypeReference<List<ProvestatusResource>>() {};
    }
}
