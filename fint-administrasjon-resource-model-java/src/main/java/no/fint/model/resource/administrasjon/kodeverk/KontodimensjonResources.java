package no.fint.model.resource.administrasjon.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class KontodimensjonResources extends AbstractCollectionResources<KontodimensjonResource> {

    public KontodimensjonResources(Collection<KontodimensjonResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<KontodimensjonResource>> getTypeReference() {
        return new TypeReference<List<KontodimensjonResource>>() {};
    }
}
