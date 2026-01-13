package no.novari.fint.model.resource.administrasjon.kompleksedatatyper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class KontostrengResources extends AbstractCollectionResources<KontostrengResource> {

    public KontostrengResources(Collection<KontostrengResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<KontostrengResource>> getTypeReference() {
        return new TypeReference<List<KontostrengResource>>() {};
    }
}
