package no.novari.fint.model.resource.utdanning.vurdering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collection;
import java.util.List;
import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class SensorResources extends AbstractCollectionResources<SensorResource> {

  public SensorResources(Collection<SensorResource> input) {
    super(input);
  }

  @JsonIgnore
  @Deprecated
  @Override
  public TypeReference<List<SensorResource>> getTypeReference() {
    return new TypeReference<List<SensorResource>>() {};
  }
}
