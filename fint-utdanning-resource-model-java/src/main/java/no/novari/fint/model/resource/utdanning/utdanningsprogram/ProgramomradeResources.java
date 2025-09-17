package no.novari.fint.model.resource.utdanning.utdanningsprogram;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class ProgramomradeResources extends AbstractCollectionResources<ProgramomradeResource> {

    public ProgramomradeResources(Collection<ProgramomradeResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<ProgramomradeResource>> getTypeReference() {
        return new TypeReference<List<ProgramomradeResource>>() {};
    }
}
