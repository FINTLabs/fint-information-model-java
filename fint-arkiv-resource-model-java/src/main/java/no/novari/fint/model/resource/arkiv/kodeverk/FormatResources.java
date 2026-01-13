package no.novari.fint.model.resource.arkiv.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class FormatResources extends AbstractCollectionResources<FormatResource> {

    public FormatResources(Collection<FormatResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<FormatResource>> getTypeReference() {
        return new TypeReference<List<FormatResource>>() {};
    }
}
