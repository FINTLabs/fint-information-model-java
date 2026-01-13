package no.novari.fint.model.resource.felles.basisklasser;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class BegrepResources extends AbstractCollectionResources<BegrepResource> {

    public BegrepResources(Collection<BegrepResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<BegrepResource>> getTypeReference() {
        return new TypeReference<List<BegrepResource>>() {};
    }
}
