package no.novari.fint.model.resource.utdanning.timeplan;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collection;
import java.util.List;
import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class TimeResources extends AbstractCollectionResources<TimeResource> {

  public TimeResources(Collection<TimeResource> input) {
    super(input);
  }

  @JsonIgnore
  @Deprecated
  @Override
  public TypeReference<List<TimeResource>> getTypeReference() {
    return new TypeReference<List<TimeResource>>() {};
  }
}
