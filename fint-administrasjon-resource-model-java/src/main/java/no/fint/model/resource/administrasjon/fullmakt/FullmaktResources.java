package no.fint.model.resource.administrasjon.fullmakt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class FullmaktResources extends AbstractCollectionResources<FullmaktResource> {

    public FullmaktResources(Collection<FullmaktResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<FullmaktResource>> getTypeReference() {
        return new TypeReference<List<FullmaktResource>>() {};
    }
}
