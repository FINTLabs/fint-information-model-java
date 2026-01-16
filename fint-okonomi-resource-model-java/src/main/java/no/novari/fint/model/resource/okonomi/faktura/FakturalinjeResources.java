package no.novari.fint.model.resource.okonomi.faktura;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collection;
import java.util.List;
import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class FakturalinjeResources extends AbstractCollectionResources<FakturalinjeResource> {

  public FakturalinjeResources(Collection<FakturalinjeResource> input) {
    super(input);
  }

  @JsonIgnore
  @Deprecated
  @Override
  public TypeReference<List<FakturalinjeResource>> getTypeReference() {
    return new TypeReference<List<FakturalinjeResource>>() {};
  }
}
