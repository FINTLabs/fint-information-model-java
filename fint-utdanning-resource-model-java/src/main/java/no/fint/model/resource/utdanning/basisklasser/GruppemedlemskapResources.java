package no.fint.model.resource.utdanning.basisklasser;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class GruppemedlemskapResources extends AbstractCollectionResources<GruppemedlemskapResource> {

    public GruppemedlemskapResources(Collection<GruppemedlemskapResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<GruppemedlemskapResource>> getTypeReference() {
        return new TypeReference<List<GruppemedlemskapResource>>() {};
    }
}
