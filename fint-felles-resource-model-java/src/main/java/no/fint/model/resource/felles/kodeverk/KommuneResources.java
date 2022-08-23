package no.fint.model.resource.felles.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class KommuneResources extends AbstractCollectionResources<KommuneResource> {

    public KommuneResources(Collection<KommuneResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<KommuneResource>> getTypeReference() {
        return new TypeReference<List<KommuneResource>>() {};
    }
}
