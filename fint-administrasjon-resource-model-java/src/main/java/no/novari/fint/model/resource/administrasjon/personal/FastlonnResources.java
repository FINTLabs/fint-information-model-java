package no.novari.fint.model.resource.administrasjon.personal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class FastlonnResources extends AbstractCollectionResources<FastlonnResource> {

    public FastlonnResources(Collection<FastlonnResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<FastlonnResource>> getTypeReference() {
        return new TypeReference<List<FastlonnResource>>() {};
    }
}
