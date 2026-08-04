package no.novari.fint.model.resource.ressurs.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class LisensmodellResources extends AbstractCollectionResources<LisensmodellResource> {

    public LisensmodellResources(Collection<LisensmodellResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<LisensmodellResource>> getTypeReference() {
        return new TypeReference<List<LisensmodellResource>>() {};
    }
}
