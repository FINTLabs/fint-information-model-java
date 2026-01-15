package no.novari.fint.model.resource.administrasjon.personal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collection;
import java.util.List;
import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class VariabellonnResources extends AbstractCollectionResources<VariabellonnResource> {

  public VariabellonnResources(Collection<VariabellonnResource> input) {
    super(input);
  }

  @JsonIgnore
  @Deprecated
  @Override
  public TypeReference<List<VariabellonnResource>> getTypeReference() {
    return new TypeReference<List<VariabellonnResource>>() {};
  }
}
