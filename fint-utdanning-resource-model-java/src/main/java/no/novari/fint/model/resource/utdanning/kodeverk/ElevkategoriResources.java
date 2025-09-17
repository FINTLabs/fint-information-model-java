package no.novari.fint.model.resource.utdanning.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class ElevkategoriResources extends AbstractCollectionResources<ElevkategoriResource> {

    public ElevkategoriResources(Collection<ElevkategoriResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<ElevkategoriResource>> getTypeReference() {
        return new TypeReference<List<ElevkategoriResource>>() {};
    }
}
