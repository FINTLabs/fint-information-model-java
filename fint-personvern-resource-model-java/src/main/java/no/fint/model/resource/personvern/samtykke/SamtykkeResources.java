package no.fint.model.resource.personvern.samtykke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class SamtykkeResources extends AbstractCollectionResources<SamtykkeResource> {

    public SamtykkeResources(Collection<SamtykkeResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<SamtykkeResource>> getTypeReference() {
        return new TypeReference<List<SamtykkeResource>>() {};
    }
}
