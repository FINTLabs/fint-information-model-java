package no.novari.fint.model.resource.ressurs.eiendel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import no.novari.fint.model.FintIdentifikator;
import no.novari.fint.model.felles.kompleksedatatyper.Identifikator;
import no.novari.fint.model.felles.kompleksedatatyper.Periode;
import no.novari.fint.model.resource.FintResource;
import no.novari.fint.model.resource.Link;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ApplikasjonsressursResource implements FintResource {
  // Attributes
  private String beskrivelse;
  private Long enhetskostnad;
  @NotNull private @Valid Periode gyldighetsperiode;
  private Boolean kreverGodkjenning;
  private Long lisensantall;
  @NotBlank private String navn;
  @NotNull private @Valid Identifikator systemId;

  @JsonIgnore
  public Map<String, FintIdentifikator> getIdentifikators() {
    Map<String, FintIdentifikator> identifikators = new HashMap<>();
    identifikators.put("systemId", this.systemId);

    return Collections.unmodifiableMap(identifikators);
  }

  // Relations
  @Getter private final Map<String, List<Link>> links = createLinks();

  @JsonIgnore
  public List<Link> getBrukertype() {
    return getLinks().getOrDefault("brukertype", Collections.emptyList());
  }

  public void addBrukertype(Link link) {
    addLink("brukertype", link);
  }

  @JsonIgnore
  public List<Link> getHandhevingstype() {
    return getLinks().getOrDefault("handhevingstype", Collections.emptyList());
  }

  public void addHandhevingstype(Link link) {
    addLink("handhevingstype", link);
  }

  @JsonIgnore
  public List<Link> getLisensmodell() {
    return getLinks().getOrDefault("lisensmodell", Collections.emptyList());
  }

  public void addLisensmodell(Link link) {
    addLink("lisensmodell", link);
  }

  @JsonIgnore
  public List<Link> getRessurstilgjengelighet() {
    return getLinks().getOrDefault("ressurstilgjengelighet", Collections.emptyList());
  }

  public void addRessurstilgjengelighet(Link link) {
    addLink("ressurstilgjengelighet", link);
  }

  @JsonIgnore
  public List<Link> getEier() {
    return getLinks().getOrDefault("eier", Collections.emptyList());
  }

  public void addEier(Link link) {
    addLink("eier", link);
  }

  @JsonIgnore
  public List<Link> getApplikasjon() {
    return getLinks().getOrDefault("applikasjon", Collections.emptyList());
  }

  public void addApplikasjon(Link link) {
    addLink("applikasjon", link);
  }
}
