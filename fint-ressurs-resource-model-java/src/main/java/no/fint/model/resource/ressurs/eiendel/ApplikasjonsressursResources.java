package no.fint.model.resource.ressurs.eiendel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class ApplikasjonsressursResources extends AbstractCollectionResources<ApplikasjonsressursResource> {

    public ApplikasjonsressursResources(Collection<ApplikasjonsressursResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<ApplikasjonsressursResource>> getTypeReference() {
        return new TypeReference<List<ApplikasjonsressursResource>>() {};
    }
}
