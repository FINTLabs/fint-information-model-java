package no.fint.model.resource.utdanning.utdanningsprogram;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class ProgramomrademedlemskapResources extends AbstractCollectionResources<ProgramomrademedlemskapResource> {

    public ProgramomrademedlemskapResources(Collection<ProgramomrademedlemskapResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<ProgramomrademedlemskapResource>> getTypeReference() {
        return new TypeReference<List<ProgramomrademedlemskapResource>>() {};
    }
}
