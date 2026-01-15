package no.novari.fint.model.resource.personvern.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collection;
import java.util.List;
import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class BehandlingsgrunnlagResources
    extends AbstractCollectionResources<BehandlingsgrunnlagResource> {

  public BehandlingsgrunnlagResources(Collection<BehandlingsgrunnlagResource> input) {
    super(input);
  }

  @JsonIgnore
  @Deprecated
  @Override
  public TypeReference<List<BehandlingsgrunnlagResource>> getTypeReference() {
    return new TypeReference<List<BehandlingsgrunnlagResource>>() {};
  }
}
