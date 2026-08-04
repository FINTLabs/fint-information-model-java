package no.novari.fint.model.resource.administrasjon.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class AnsvarResources extends AbstractCollectionResources<AnsvarResource> {

    public AnsvarResources(Collection<AnsvarResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<AnsvarResource>> getTypeReference() {
        return new TypeReference<List<AnsvarResource>>() {};
    }
}
