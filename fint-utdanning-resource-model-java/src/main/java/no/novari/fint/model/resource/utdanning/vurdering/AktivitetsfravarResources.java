package no.novari.fint.model.resource.utdanning.vurdering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collection;
import java.util.List;
import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class AktivitetsfravarResources
    extends AbstractCollectionResources<AktivitetsfravarResource> {

  public AktivitetsfravarResources(Collection<AktivitetsfravarResource> input) {
    super(input);
  }

  @JsonIgnore
  @Deprecated
  @Override
  public TypeReference<List<AktivitetsfravarResource>> getTypeReference() {
    return new TypeReference<List<AktivitetsfravarResource>>() {};
  }
}
