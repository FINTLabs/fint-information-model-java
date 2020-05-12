// Built from tag v3.5.0

package no.fint.model.resource.felles.kodeverk.iso;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class KjonnResources extends AbstractCollectionResources<KjonnResource> {

    public KjonnResources(Collection<KjonnResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<KjonnResource>> getTypeReference() {
        return new TypeReference<List<KjonnResource>>() {};
    }
}
