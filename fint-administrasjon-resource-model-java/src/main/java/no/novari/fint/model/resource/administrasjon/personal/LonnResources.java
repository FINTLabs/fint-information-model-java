package no.novari.fint.model.resource.administrasjon.personal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collection;
import java.util.List;
import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class LonnResources extends AbstractCollectionResources<LonnResource> {

  public LonnResources(Collection<LonnResource> input) {
    super(input);
  }

  @JsonIgnore
  @Deprecated
  @Override
  public TypeReference<List<LonnResource>> getTypeReference() {
    return new TypeReference<List<LonnResource>>() {};
  }
}
