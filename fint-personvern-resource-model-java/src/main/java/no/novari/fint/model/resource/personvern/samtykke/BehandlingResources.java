package no.novari.fint.model.resource.personvern.samtykke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collection;
import java.util.List;
import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class BehandlingResources extends AbstractCollectionResources<BehandlingResource> {

  public BehandlingResources(Collection<BehandlingResource> input) {
    super(input);
  }

  @JsonIgnore
  @Deprecated
  @Override
  public TypeReference<List<BehandlingResource>> getTypeReference() {
    return new TypeReference<List<BehandlingResource>>() {};
  }
}
