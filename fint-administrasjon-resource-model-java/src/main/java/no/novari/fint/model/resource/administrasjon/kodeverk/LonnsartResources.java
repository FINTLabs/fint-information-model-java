package no.novari.fint.model.resource.administrasjon.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class LonnsartResources extends AbstractCollectionResources<LonnsartResource> {

    public LonnsartResources(Collection<LonnsartResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<LonnsartResource>> getTypeReference() {
        return new TypeReference<List<LonnsartResource>>() {};
    }
}
