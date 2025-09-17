package no.novari.fint.model.resource.arkiv.noark;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class AdministrativEnhetResources extends AbstractCollectionResources<AdministrativEnhetResource> {

    public AdministrativEnhetResources(Collection<AdministrativEnhetResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<AdministrativEnhetResource>> getTypeReference() {
        return new TypeReference<List<AdministrativEnhetResource>>() {};
    }
}
