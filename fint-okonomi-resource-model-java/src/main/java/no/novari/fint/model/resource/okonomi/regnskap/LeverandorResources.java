package no.novari.fint.model.resource.okonomi.regnskap;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class LeverandorResources extends AbstractCollectionResources<LeverandorResource> {

    public LeverandorResources(Collection<LeverandorResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<LeverandorResource>> getTypeReference() {
        return new TypeReference<List<LeverandorResource>>() {};
    }
}
