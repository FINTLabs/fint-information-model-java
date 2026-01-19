package no.novari.fint.model.resource.utdanning.elev;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collection;
import java.util.List;
import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class PersongruppemedlemskapResources
    extends AbstractCollectionResources<PersongruppemedlemskapResource> {

  public PersongruppemedlemskapResources(Collection<PersongruppemedlemskapResource> input) {
    super(input);
  }

  @JsonIgnore
  @Deprecated
  @Override
  public TypeReference<List<PersongruppemedlemskapResource>> getTypeReference() {
    return new TypeReference<List<PersongruppemedlemskapResource>>() {};
  }
}
