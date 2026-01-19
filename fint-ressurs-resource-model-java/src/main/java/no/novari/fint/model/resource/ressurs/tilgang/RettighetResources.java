package no.novari.fint.model.resource.ressurs.tilgang;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collection;
import java.util.List;
import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class RettighetResources extends AbstractCollectionResources<RettighetResource> {

  public RettighetResources(Collection<RettighetResource> input) {
    super(input);
  }

  @JsonIgnore
  @Deprecated
  @Override
  public TypeReference<List<RettighetResource>> getTypeReference() {
    return new TypeReference<List<RettighetResource>>() {};
  }
}
