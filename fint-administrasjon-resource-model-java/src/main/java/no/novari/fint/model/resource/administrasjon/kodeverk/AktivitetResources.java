package no.novari.fint.model.resource.administrasjon.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class AktivitetResources extends AbstractCollectionResources<AktivitetResource> {

    public AktivitetResources(Collection<AktivitetResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<AktivitetResource>> getTypeReference() {
        return new TypeReference<List<AktivitetResource>>() {};
    }
}
