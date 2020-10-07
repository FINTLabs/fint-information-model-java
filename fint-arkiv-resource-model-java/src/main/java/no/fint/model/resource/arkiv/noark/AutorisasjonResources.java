package no.fint.model.resource.arkiv.noark;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class AutorisasjonResources extends AbstractCollectionResources<AutorisasjonResource> {

    public AutorisasjonResources(Collection<AutorisasjonResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<AutorisasjonResource>> getTypeReference() {
        return new TypeReference<List<AutorisasjonResource>>() {};
    }
}
