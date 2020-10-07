package no.fint.model.resource.okonomi.faktura;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class FakturagrunnlagResources extends AbstractCollectionResources<FakturagrunnlagResource> {

    public FakturagrunnlagResources(Collection<FakturagrunnlagResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<FakturagrunnlagResource>> getTypeReference() {
        return new TypeReference<List<FakturagrunnlagResource>>() {};
    }
}
