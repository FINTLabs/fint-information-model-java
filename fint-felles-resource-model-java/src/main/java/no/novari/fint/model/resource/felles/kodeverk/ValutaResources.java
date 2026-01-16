package no.novari.fint.model.resource.felles.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collection;
import java.util.List;
import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class ValutaResources extends AbstractCollectionResources<ValutaResource> {

  public ValutaResources(Collection<ValutaResource> input) {
    super(input);
  }

  @JsonIgnore
  @Deprecated
  @Override
  public TypeReference<List<ValutaResource>> getTypeReference() {
    return new TypeReference<List<ValutaResource>>() {};
  }
}
