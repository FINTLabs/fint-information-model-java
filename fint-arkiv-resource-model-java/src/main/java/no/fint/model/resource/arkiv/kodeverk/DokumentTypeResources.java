package no.fint.model.resource.arkiv.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class DokumentTypeResources extends AbstractCollectionResources<DokumentTypeResource> {

    public DokumentTypeResources(Collection<DokumentTypeResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<DokumentTypeResource>> getTypeReference() {
        return new TypeReference<List<DokumentTypeResource>>() {};
    }
}
