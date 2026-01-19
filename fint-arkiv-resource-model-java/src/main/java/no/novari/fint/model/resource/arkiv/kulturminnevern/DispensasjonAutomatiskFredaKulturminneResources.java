package no.novari.fint.model.resource.arkiv.kulturminnevern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collection;
import java.util.List;
import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class DispensasjonAutomatiskFredaKulturminneResources
    extends AbstractCollectionResources<DispensasjonAutomatiskFredaKulturminneResource> {

  public DispensasjonAutomatiskFredaKulturminneResources(
      Collection<DispensasjonAutomatiskFredaKulturminneResource> input) {
    super(input);
  }

  @JsonIgnore
  @Deprecated
  @Override
  public TypeReference<List<DispensasjonAutomatiskFredaKulturminneResource>> getTypeReference() {
    return new TypeReference<List<DispensasjonAutomatiskFredaKulturminneResource>>() {};
  }
}
