package no.novari.fint.model.resource.felles.basisklasser;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collection;
import java.util.List;
import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class AktorResources extends AbstractCollectionResources<AktorResource> {

  public AktorResources(Collection<AktorResource> input) {
    super(input);
  }

  @JsonIgnore
  @Deprecated
  @Override
  public TypeReference<List<AktorResource>> getTypeReference() {
    return new TypeReference<List<AktorResource>>() {};
  }
}
