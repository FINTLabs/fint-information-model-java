package no.novari.fint.model.resource.administrasjon.organisasjon;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collection;
import java.util.List;
import lombok.NoArgsConstructor;
import no.novari.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class OrganisasjonselementResources
    extends AbstractCollectionResources<OrganisasjonselementResource> {

  public OrganisasjonselementResources(Collection<OrganisasjonselementResource> input) {
    super(input);
  }

  @JsonIgnore
  @Deprecated
  @Override
  public TypeReference<List<OrganisasjonselementResource>> getTypeReference() {
    return new TypeReference<List<OrganisasjonselementResource>>() {};
  }
}
