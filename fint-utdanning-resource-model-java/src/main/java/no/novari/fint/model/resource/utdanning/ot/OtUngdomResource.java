package no.novari.fint.model.resource.utdanning.ot;

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
import no.novari.fint.model.resource.FintResource;
import no.novari.fint.model.resource.Link;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class OtUngdomResource implements FintResource {
  // Attributes
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
  public List<Link> getPerson() {
    return getLinks().getOrDefault("person", Collections.emptyList());
  }

  public void addPerson(Link link) {
    addLink("person", link);
  }

  @JsonIgnore
  public List<Link> getStatus() {
    return getLinks().getOrDefault("status", Collections.emptyList());
  }

  public void addStatus(Link link) {
    addLink("status", link);
  }

  @JsonIgnore
  public List<Link> getEnhet() {
    return getLinks().getOrDefault("enhet", Collections.emptyList());
  }

  public void addEnhet(Link link) {
    addLink("enhet", link);
  }

  @JsonIgnore
  public List<Link> getProgramomrade() {
    return getLinks().getOrDefault("programomrade", Collections.emptyList());
  }

  public void addProgramomrade(Link link) {
    addLink("programomrade", link);
  }
}
