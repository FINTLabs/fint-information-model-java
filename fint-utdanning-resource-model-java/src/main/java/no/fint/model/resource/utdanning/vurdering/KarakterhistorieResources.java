package no.fint.model.resource.utdanning.vurdering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class KarakterhistorieResources extends AbstractCollectionResources<KarakterhistorieResource> {

    public KarakterhistorieResources(Collection<KarakterhistorieResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<KarakterhistorieResource>> getTypeReference() {
        return new TypeReference<List<KarakterhistorieResource>>() {};
    }
}
