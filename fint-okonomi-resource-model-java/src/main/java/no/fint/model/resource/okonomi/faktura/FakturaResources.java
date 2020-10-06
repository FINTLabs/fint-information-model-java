// Built from tag v3.6.0-rc-1

package no.fint.model.resource.okonomi.faktura;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class FakturaResources extends AbstractCollectionResources<FakturaResource> {

    public FakturaResources(Collection<FakturaResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<FakturaResource>> getTypeReference() {
        return new TypeReference<List<FakturaResource>>() {};
    }
}
