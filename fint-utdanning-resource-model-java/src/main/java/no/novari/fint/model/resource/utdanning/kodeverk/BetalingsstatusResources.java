package no.novari.fint.model.resource.utdanning.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collection;
import java.util.List;
import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class BetalingsstatusResources extends AbstractCollectionResources<BetalingsstatusResource> {

  public BetalingsstatusResources(Collection<BetalingsstatusResource> input) {
    super(input);
  }

  @JsonIgnore
  @Deprecated
  @Override
  public TypeReference<List<BetalingsstatusResource>> getTypeReference() {
    return new TypeReference<List<BetalingsstatusResource>>() {};
  }
}
