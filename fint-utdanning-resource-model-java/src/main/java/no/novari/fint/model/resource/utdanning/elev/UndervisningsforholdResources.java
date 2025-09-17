package no.novari.fint.model.resource.utdanning.elev;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class UndervisningsforholdResources extends AbstractCollectionResources<UndervisningsforholdResource> {

    public UndervisningsforholdResources(Collection<UndervisningsforholdResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<UndervisningsforholdResource>> getTypeReference() {
        return new TypeReference<List<UndervisningsforholdResource>>() {};
    }
}
