package no.novari.fint.model.resource.ressurs.eiendel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class ApplikasjonsressurstilgjengelighetResources extends AbstractCollectionResources<ApplikasjonsressurstilgjengelighetResource> {

    public ApplikasjonsressurstilgjengelighetResources(Collection<ApplikasjonsressurstilgjengelighetResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<ApplikasjonsressurstilgjengelighetResource>> getTypeReference() {
        return new TypeReference<List<ApplikasjonsressurstilgjengelighetResource>>() {};
    }
}
