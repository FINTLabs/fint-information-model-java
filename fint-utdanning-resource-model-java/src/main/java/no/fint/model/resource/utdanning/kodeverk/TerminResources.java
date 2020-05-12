// Built from tag v3.5.0

package no.fint.model.resource.utdanning.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class TerminResources extends AbstractCollectionResources<TerminResource> {

    public TerminResources(Collection<TerminResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<TerminResource>> getTypeReference() {
        return new TypeReference<List<TerminResource>>() {};
    }
}
