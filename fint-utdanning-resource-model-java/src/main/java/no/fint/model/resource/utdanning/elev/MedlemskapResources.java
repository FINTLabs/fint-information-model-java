// Built from tag v3.6.0-rc-1

package no.fint.model.resource.utdanning.elev;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
@Deprecated
public class MedlemskapResources extends AbstractCollectionResources<MedlemskapResource> {

    public MedlemskapResources(Collection<MedlemskapResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<MedlemskapResource>> getTypeReference() {
        return new TypeReference<List<MedlemskapResource>>() {};
    }
}
