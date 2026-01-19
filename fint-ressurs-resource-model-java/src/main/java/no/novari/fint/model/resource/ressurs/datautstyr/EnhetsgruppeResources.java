package no.novari.fint.model.resource.ressurs.datautstyr;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collection;
import java.util.List;
import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class EnhetsgruppeResources extends AbstractCollectionResources<EnhetsgruppeResource> {

  public EnhetsgruppeResources(Collection<EnhetsgruppeResource> input) {
    super(input);
  }

  @JsonIgnore
  @Deprecated
  @Override
  public TypeReference<List<EnhetsgruppeResource>> getTypeReference() {
    return new TypeReference<List<EnhetsgruppeResource>>() {};
  }
}
