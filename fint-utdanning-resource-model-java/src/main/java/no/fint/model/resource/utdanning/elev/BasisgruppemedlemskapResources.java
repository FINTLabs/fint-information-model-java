// Built from tag v3.5.0

package no.fint.model.resource.utdanning.elev;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class BasisgruppemedlemskapResources extends AbstractCollectionResources<BasisgruppemedlemskapResource> {

    public BasisgruppemedlemskapResources(Collection<BasisgruppemedlemskapResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<BasisgruppemedlemskapResource>> getTypeReference() {
        return new TypeReference<List<BasisgruppemedlemskapResource>>() {};
    }
}
