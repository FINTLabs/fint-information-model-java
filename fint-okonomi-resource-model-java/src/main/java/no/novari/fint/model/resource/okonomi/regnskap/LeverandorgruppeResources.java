package no.novari.fint.model.resource.okonomi.regnskap;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class LeverandorgruppeResources extends AbstractCollectionResources<LeverandorgruppeResource> {

    public LeverandorgruppeResources(Collection<LeverandorgruppeResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<LeverandorgruppeResource>> getTypeReference() {
        return new TypeReference<List<LeverandorgruppeResource>>() {};
    }
}
