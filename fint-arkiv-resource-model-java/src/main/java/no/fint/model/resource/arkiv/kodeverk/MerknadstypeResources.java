package no.fint.model.resource.arkiv.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class MerknadstypeResources extends AbstractCollectionResources<MerknadstypeResource> {

    public MerknadstypeResources(Collection<MerknadstypeResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<MerknadstypeResource>> getTypeReference() {
        return new TypeReference<List<MerknadstypeResource>>() {};
    }
}
