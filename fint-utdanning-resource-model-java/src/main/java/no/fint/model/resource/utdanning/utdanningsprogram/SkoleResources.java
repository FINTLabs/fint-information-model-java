// Built from tag v3.5.0

package no.fint.model.resource.utdanning.utdanningsprogram;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class SkoleResources extends AbstractCollectionResources<SkoleResource> {

    public SkoleResources(Collection<SkoleResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<SkoleResource>> getTypeReference() {
        return new TypeReference<List<SkoleResource>>() {};
    }
}
