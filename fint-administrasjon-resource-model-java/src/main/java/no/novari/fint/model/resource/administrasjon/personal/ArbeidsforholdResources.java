package no.novari.fint.model.resource.administrasjon.personal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class ArbeidsforholdResources extends AbstractCollectionResources<ArbeidsforholdResource> {

    public ArbeidsforholdResources(Collection<ArbeidsforholdResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<ArbeidsforholdResource>> getTypeReference() {
        return new TypeReference<List<ArbeidsforholdResource>>() {};
    }
}
