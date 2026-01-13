package no.novari.fint.model.resource.ressurs.datautstyr;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class EnhetsgruppemedlemskapResources extends AbstractCollectionResources<EnhetsgruppemedlemskapResource> {

    public EnhetsgruppemedlemskapResources(Collection<EnhetsgruppemedlemskapResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<EnhetsgruppemedlemskapResource>> getTypeReference() {
        return new TypeReference<List<EnhetsgruppemedlemskapResource>>() {};
    }
}
