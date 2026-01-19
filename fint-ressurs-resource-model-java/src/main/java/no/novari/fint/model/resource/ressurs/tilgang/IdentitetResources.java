package no.novari.fint.model.resource.ressurs.tilgang;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collection;
import java.util.List;
import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class IdentitetResources extends AbstractCollectionResources<IdentitetResource> {

  public IdentitetResources(Collection<IdentitetResource> input) {
    super(input);
  }

  @JsonIgnore
  @Deprecated
  @Override
  public TypeReference<List<IdentitetResource>> getTypeReference() {
    return new TypeReference<List<IdentitetResource>>() {};
  }
}
