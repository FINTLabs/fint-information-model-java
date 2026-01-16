package no.novari.fint.model.resource.utdanning.basisklasser;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collection;
import java.util.List;
import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class UtdanningsforholdResources
    extends AbstractCollectionResources<UtdanningsforholdResource> {

  public UtdanningsforholdResources(Collection<UtdanningsforholdResource> input) {
    super(input);
  }

  @JsonIgnore
  @Deprecated
  @Override
  public TypeReference<List<UtdanningsforholdResource>> getTypeReference() {
    return new TypeReference<List<UtdanningsforholdResource>>() {};
  }
}
