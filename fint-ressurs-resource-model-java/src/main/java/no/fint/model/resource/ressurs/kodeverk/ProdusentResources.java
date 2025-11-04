package no.fint.model.resource.ressurs.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class ProdusentResources extends AbstractCollectionResources<ProdusentResource> {

    public ProdusentResources(Collection<ProdusentResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<ProdusentResource>> getTypeReference() {
        return new TypeReference<List<ProdusentResource>>() {};
    }
}
