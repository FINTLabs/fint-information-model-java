package no.fint.model.resource.ressurs.eiendel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class ApplikasjonResources extends AbstractCollectionResources<ApplikasjonResource> {

    public ApplikasjonResources(Collection<ApplikasjonResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<ApplikasjonResource>> getTypeReference() {
        return new TypeReference<List<ApplikasjonResource>>() {};
    }
}
