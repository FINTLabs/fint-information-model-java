// Built from tag v3.5.0

package no.fint.model.resource.utdanning.vurdering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class EksamensgruppemedlemskapResources extends AbstractCollectionResources<EksamensgruppemedlemskapResource> {

    public EksamensgruppemedlemskapResources(Collection<EksamensgruppemedlemskapResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<EksamensgruppemedlemskapResource>> getTypeReference() {
        return new TypeReference<List<EksamensgruppemedlemskapResource>>() {};
    }
}
