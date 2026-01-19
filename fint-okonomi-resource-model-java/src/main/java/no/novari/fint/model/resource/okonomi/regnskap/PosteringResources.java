package no.novari.fint.model.resource.okonomi.regnskap;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collection;
import java.util.List;
import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class PosteringResources extends AbstractCollectionResources<PosteringResource> {

  public PosteringResources(Collection<PosteringResource> input) {
    super(input);
  }

  @JsonIgnore
  @Deprecated
  @Override
  public TypeReference<List<PosteringResource>> getTypeReference() {
    return new TypeReference<List<PosteringResource>>() {};
  }
}
