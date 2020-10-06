// Built from tag v3.6.0-rc-1

package no.fint.model.resource.felles.kompleksedatatyper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class MatrikkelnummerResources extends AbstractCollectionResources<MatrikkelnummerResource> {

    public MatrikkelnummerResources(Collection<MatrikkelnummerResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<MatrikkelnummerResource>> getTypeReference() {
        return new TypeReference<List<MatrikkelnummerResource>>() {};
    }
}
