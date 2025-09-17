package no.novari.fint.model.resource.utdanning.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class VarseltypeResources extends AbstractCollectionResources<VarseltypeResource> {

    public VarseltypeResources(Collection<VarseltypeResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<VarseltypeResource>> getTypeReference() {
        return new TypeReference<List<VarseltypeResource>>() {};
    }
}
