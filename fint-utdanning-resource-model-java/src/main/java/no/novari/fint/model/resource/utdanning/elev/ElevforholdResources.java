package no.novari.fint.model.resource.utdanning.elev;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class ElevforholdResources extends AbstractCollectionResources<ElevforholdResource> {

    public ElevforholdResources(Collection<ElevforholdResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<ElevforholdResource>> getTypeReference() {
        return new TypeReference<List<ElevforholdResource>>() {};
    }
}
