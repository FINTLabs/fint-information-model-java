package no.novari.fint.model.resource.administrasjon.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collection;
import java.util.List;
import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class RammeResources extends AbstractCollectionResources<RammeResource> {

  public RammeResources(Collection<RammeResource> input) {
    super(input);
  }

  @JsonIgnore
  @Deprecated
  @Override
  public TypeReference<List<RammeResource>> getTypeReference() {
    return new TypeReference<List<RammeResource>>() {};
  }
}
