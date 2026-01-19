package no.novari.fint.model.utdanning.timeplan;

import static no.novari.fint.model.FintMultiplicity.NONE_TO_MANY;
import static no.novari.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.ONE_TO_ONE;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import no.novari.fint.model.FintIdentifikator;
import no.novari.fint.model.FintModelObject;
import no.novari.fint.model.FintMultiplicity;
import no.novari.fint.model.FintRelation;
import no.novari.fint.model.utdanning.basisklasser.Gruppemedlemskap;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Faggruppemedlemskap extends Gruppemedlemskap implements FintModelObject {
  @Getter
  public enum Relasjonsnavn implements FintRelation {
    FAGMERKNAD(
        "fagmerknad",
        "no.novari.fint.model.utdanning.kodeverk.Fagmerknad",
        NONE_TO_ONE,
        null,
        null),
    FAGSTATUS(
        "fagstatus", "no.novari.fint.model.utdanning.kodeverk.Fagstatus", NONE_TO_ONE, null, null),
    ELEVFORHOLD(
        "elevforhold", "no.novari.fint.model.utdanning.elev.Elevforhold", ONE_TO_ONE, null, null),
    VARSEL(
        "varsel",
        "no.novari.fint.model.utdanning.elev.Varsel",
        NONE_TO_MANY,
        false,
        "faggruppemedlemskap"),
    FAGGRUPPE(
        "faggruppe",
        "no.novari.fint.model.utdanning.timeplan.Faggruppe",
        ONE_TO_ONE,
        false,
        "faggruppemedlemskap");

    private final String name;
    private final String packageName;
    private final FintMultiplicity multiplicity;
    private final String inverseName;
    private final Boolean isSource;

    private Relasjonsnavn(
        String name,
        String packageName,
        FintMultiplicity multiplicity,
        Boolean isSource,
        String inverseName) {
      this.name = name;
      this.packageName = packageName;
      this.multiplicity = multiplicity;
      this.inverseName = inverseName;
      this.isSource = isSource;
    }
  }

  @JsonIgnore
  public Map<String, FintIdentifikator> getIdentifikators() {
    Map<String, FintIdentifikator> identifikators = new HashMap<>();
    identifikators.putAll(super.getIdentifikators());

    return Collections.unmodifiableMap(identifikators);
  }

  @JsonIgnore
  private List<FintRelation> createRelations() {
    List<FintRelation> relations = new ArrayList<>();

    relations.addAll(Arrays.asList(Relasjonsnavn.values()));

    return Collections.unmodifiableList(relations);
  }

  public boolean isWriteable() {
    return this.writeable;
  }

  @JsonIgnore private final boolean writeable = false;
  @JsonIgnore private final List<FintRelation> relations = createRelations();
}
