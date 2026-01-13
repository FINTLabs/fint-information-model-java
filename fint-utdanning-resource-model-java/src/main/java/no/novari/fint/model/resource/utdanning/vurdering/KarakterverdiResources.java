package no.novari.fint.model.resource.utdanning.vurdering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class KarakterverdiResources extends AbstractCollectionResources<KarakterverdiResource> {

    public KarakterverdiResources(Collection<KarakterverdiResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<KarakterverdiResource>> getTypeReference() {
        return new TypeReference<List<KarakterverdiResource>>() {};
    }
}
