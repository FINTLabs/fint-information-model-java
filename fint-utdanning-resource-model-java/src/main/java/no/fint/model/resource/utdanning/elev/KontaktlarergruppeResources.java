// Built from tag v3.5.0

package no.fint.model.resource.utdanning.elev;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class KontaktlarergruppeResources extends AbstractCollectionResources<KontaktlarergruppeResource> {

    public KontaktlarergruppeResources(Collection<KontaktlarergruppeResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<KontaktlarergruppeResource>> getTypeReference() {
        return new TypeReference<List<KontaktlarergruppeResource>>() {};
    }
}
