package no.fint.model.resource.arkiv.noark;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class JournalpostResources extends AbstractCollectionResources<JournalpostResource> {

    public JournalpostResources(Collection<JournalpostResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<JournalpostResource>> getTypeReference() {
        return new TypeReference<List<JournalpostResource>>() {};
    }
}
