package no.novari.fint.model.utdanning.timeplan;

import static no.novari.fint.model.FintMultiplicity.NONE_TO_MANY;
import static no.novari.fint.model.FintMultiplicity.NONE_TO_ONE;

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
import no.novari.fint.model.utdanning.basisklasser.Gruppe;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Fag extends Gruppe implements FintModelObject {
  @Getter
  public enum Relasjonsnavn implements FintRelation {
    GREPREFERANSE(
        "grepreferanse",
        "no.novari.fint.model.utdanning.kodeverk.Grepreferanse",
        NONE_TO_ONE,
        null),
    PROGRAMOMRADE(
        "programomrade",
        "no.novari.fint.model.utdanning.utdanningsprogram.Programomrade",
        NONE_TO_MANY,
        "fag"),
    VIGOREFERANSE(
        "vigoreferanse",
        "no.novari.fint.model.utdanning.kodeverk.Vigoreferanse",
        NONE_TO_ONE,
        null),
    TILRETTELEGGING(
        "tilrettelegging",
        "no.novari.fint.model.utdanning.elev.Elevtilrettelegging",
        NONE_TO_MANY,
        "fag"),
    FAGGRUPPE(
        "faggruppe", "no.novari.fint.model.utdanning.timeplan.Faggruppe", NONE_TO_MANY, "fag"),
    SKOLE("skole", "no.novari.fint.model.utdanning.utdanningsprogram.Skole", NONE_TO_MANY, "fag"),
    UNDERVISNINGSGRUPPE(
        "undervisningsgruppe",
        "no.novari.fint.model.utdanning.timeplan.Undervisningsgruppe",
        NONE_TO_MANY,
        "fag"),
    EKSAMENSGRUPPE(
        "eksamensgruppe",
        "no.novari.fint.model.utdanning.vurdering.Eksamensgruppe",
        NONE_TO_MANY,
        "fag");

    private final String name;
    private final String packageName;
    private final FintMultiplicity multiplicity;
    private final String inverseName;

    private Relasjonsnavn(
        String name, String packageName, FintMultiplicity multiplicity, String inverseName) {
      this.name = name;
      this.packageName = packageName;
      this.multiplicity = multiplicity;
      this.inverseName = inverseName;
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
