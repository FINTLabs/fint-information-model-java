package no.novari.fint.model.resource.utdanning.utdanningsprogram;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class ArstrinnResources extends AbstractCollectionResources<ArstrinnResource> {

    public ArstrinnResources(Collection<ArstrinnResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<ArstrinnResource>> getTypeReference() {
        return new TypeReference<List<ArstrinnResource>>() {};
    }
}
