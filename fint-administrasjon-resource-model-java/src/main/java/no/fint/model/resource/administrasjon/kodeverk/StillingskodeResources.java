package no.fint.model.resource.administrasjon.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class StillingskodeResources extends AbstractCollectionResources<StillingskodeResource> {

    public StillingskodeResources(Collection<StillingskodeResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<StillingskodeResource>> getTypeReference() {
        return new TypeReference<List<StillingskodeResource>>() {};
    }
}
