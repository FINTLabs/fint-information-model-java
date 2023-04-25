package no.fint.model.resource.utdanning.ot;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class OTUngdomResources extends AbstractCollectionResources<OTUngdomResource> {

    public OTUngdomResources(Collection<OTUngdomResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<OTUngdomResource>> getTypeReference() {
        return new TypeReference<List<OTUngdomResource>>() {};
    }
}
