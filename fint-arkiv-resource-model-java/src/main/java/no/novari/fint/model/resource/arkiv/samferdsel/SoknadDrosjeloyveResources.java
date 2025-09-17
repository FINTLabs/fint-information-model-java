package no.novari.fint.model.resource.arkiv.samferdsel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class SoknadDrosjeloyveResources extends AbstractCollectionResources<SoknadDrosjeloyveResource> {

    public SoknadDrosjeloyveResources(Collection<SoknadDrosjeloyveResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<SoknadDrosjeloyveResource>> getTypeReference() {
        return new TypeReference<List<SoknadDrosjeloyveResource>>() {};
    }
}
