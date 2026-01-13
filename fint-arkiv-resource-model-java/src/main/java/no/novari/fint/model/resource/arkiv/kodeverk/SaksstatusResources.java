package no.novari.fint.model.resource.arkiv.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class SaksstatusResources extends AbstractCollectionResources<SaksstatusResource> {

    public SaksstatusResources(Collection<SaksstatusResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<SaksstatusResource>> getTypeReference() {
        return new TypeReference<List<SaksstatusResource>>() {};
    }
}
