package no.novari.fint.model.resource.arkiv.noark;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import no.novari.fint.model.FintComplexDatatypeObject;
import no.novari.fint.model.felles.kompleksedatatyper.Kontaktinformasjon;
import no.novari.fint.model.resource.FintLinks;
import no.novari.fint.model.resource.Link;
import no.novari.fint.model.resource.felles.kompleksedatatyper.AdresseResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class KorrespondansepartResource implements FintComplexDatatypeObject, FintLinks {
  // Attributes
  @JsonIgnore
  @Override
  public List<FintLinks> getNestedResources() {
    List<FintLinks> result = FintLinks.super.getNestedResources();
    if (adresse != null) {
      result.add(adresse);
    }
    if (skjerming != null) {
      result.add(skjerming);
    }
    return result;
  }

  private @Valid AdresseResource adresse;
  private String fodselsnummer;
  private @Valid Kontaktinformasjon kontaktinformasjon;
  private String kontaktperson;
  private String korrespondansepartNavn;
  private String organisasjonsnummer;
  private @Valid SkjermingResource skjerming;

  // Relations
  @Getter private final Map<String, List<Link>> links = createLinks();

  @JsonIgnore
  public List<Link> getKorrespondanseparttype() {
    return getLinks().getOrDefault("korrespondanseparttype", Collections.emptyList());
  }

  public void addKorrespondanseparttype(Link link) {
    addLink("korrespondanseparttype", link);
  }
}
