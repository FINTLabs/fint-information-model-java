package no.novari.fint.model.resource.arkiv.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class DokumentStatusResources extends AbstractCollectionResources<DokumentStatusResource> {

    public DokumentStatusResources(Collection<DokumentStatusResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<DokumentStatusResource>> getTypeReference() {
        return new TypeReference<List<DokumentStatusResource>>() {};
    }
}
