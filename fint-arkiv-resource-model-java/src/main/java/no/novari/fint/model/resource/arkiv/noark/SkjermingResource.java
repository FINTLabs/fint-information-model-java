package no.novari.fint.model.resource.arkiv.noark;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import no.novari.fint.model.FintComplexDatatypeObject;
import no.novari.fint.model.resource.FintLinks;
import no.novari.fint.model.resource.Link;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class SkjermingResource implements FintComplexDatatypeObject, FintLinks {

  // Relations
  @Getter private final Map<String, List<Link>> links = createLinks();

  @JsonIgnore
  public List<Link> getSkjermingshjemmel() {
    return getLinks().getOrDefault("skjermingshjemmel", Collections.emptyList());
  }

  public void addSkjermingshjemmel(Link link) {
    addLink("skjermingshjemmel", link);
  }

  @JsonIgnore
  public List<Link> getTilgangsrestriksjon() {
    return getLinks().getOrDefault("tilgangsrestriksjon", Collections.emptyList());
  }

  public void addTilgangsrestriksjon(Link link) {
    addLink("tilgangsrestriksjon", link);
  }
}
