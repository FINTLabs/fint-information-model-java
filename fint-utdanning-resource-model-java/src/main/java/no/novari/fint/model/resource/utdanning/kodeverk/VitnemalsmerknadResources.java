package no.novari.fint.model.resource.utdanning.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class VitnemalsmerknadResources extends AbstractCollectionResources<VitnemalsmerknadResource> {

    public VitnemalsmerknadResources(Collection<VitnemalsmerknadResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<VitnemalsmerknadResource>> getTypeReference() {
        return new TypeReference<List<VitnemalsmerknadResource>>() {};
    }
}
