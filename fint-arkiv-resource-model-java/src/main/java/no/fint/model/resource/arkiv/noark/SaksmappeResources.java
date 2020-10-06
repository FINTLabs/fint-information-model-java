// Built from tag v3.6.0-rc-1

package no.fint.model.resource.arkiv.noark;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class SaksmappeResources extends AbstractCollectionResources<SaksmappeResource> {

    public SaksmappeResources(Collection<SaksmappeResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<SaksmappeResource>> getTypeReference() {
        return new TypeReference<List<SaksmappeResource>>() {};
    }
}
