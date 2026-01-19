package no.novari.fint.model.resource.ressurs.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collection;
import java.util.List;
import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class HandhevingstypeResources extends AbstractCollectionResources<HandhevingstypeResource> {

  public HandhevingstypeResources(Collection<HandhevingstypeResource> input) {
    super(input);
  }

  @JsonIgnore
  @Deprecated
  @Override
  public TypeReference<List<HandhevingstypeResource>> getTypeReference() {
    return new TypeReference<List<HandhevingstypeResource>>() {};
  }
}
