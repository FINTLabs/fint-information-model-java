package no.fint.model.resource.ressurs.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class PlattformResources extends AbstractCollectionResources<PlattformResource> {

    public PlattformResources(Collection<PlattformResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<PlattformResource>> getTypeReference() {
        return new TypeReference<List<PlattformResource>>() {};
    }
}
