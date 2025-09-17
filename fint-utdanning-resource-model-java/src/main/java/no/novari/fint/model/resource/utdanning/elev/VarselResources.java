package no.novari.fint.model.resource.utdanning.elev;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class VarselResources extends AbstractCollectionResources<VarselResource> {

    public VarselResources(Collection<VarselResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<VarselResource>> getTypeReference() {
        return new TypeReference<List<VarselResource>>() {};
    }
}
