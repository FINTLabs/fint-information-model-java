package no.fint.model.resource.utdanning.elev;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class BasisgruppeResources extends AbstractCollectionResources<BasisgruppeResource> {

    public BasisgruppeResources(Collection<BasisgruppeResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<BasisgruppeResource>> getTypeReference() {
        return new TypeReference<List<BasisgruppeResource>>() {};
    }
}
