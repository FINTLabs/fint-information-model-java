package no.novari.fint.model.resource.utdanning.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class EksamensformResources extends AbstractCollectionResources<EksamensformResource> {

    public EksamensformResources(Collection<EksamensformResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<EksamensformResource>> getTypeReference() {
        return new TypeReference<List<EksamensformResource>>() {};
    }
}
