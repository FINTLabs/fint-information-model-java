package no.fint.model.resource.arkiv.samferdsel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class DrosjeloyveResources extends AbstractCollectionResources<DrosjeloyveResource> {

    public DrosjeloyveResources(Collection<DrosjeloyveResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<DrosjeloyveResource>> getTypeReference() {
        return new TypeReference<List<DrosjeloyveResource>>() {};
    }
}
