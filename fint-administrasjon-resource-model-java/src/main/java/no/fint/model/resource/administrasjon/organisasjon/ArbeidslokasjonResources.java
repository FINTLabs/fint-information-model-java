package no.fint.model.resource.administrasjon.organisasjon;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class ArbeidslokasjonResources extends AbstractCollectionResources<ArbeidslokasjonResource> {

    public ArbeidslokasjonResources(Collection<ArbeidslokasjonResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<ArbeidslokasjonResource>> getTypeReference() {
        return new TypeReference<List<ArbeidslokasjonResource>>() {};
    }
}
