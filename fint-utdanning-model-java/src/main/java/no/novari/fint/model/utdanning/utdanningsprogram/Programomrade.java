package no.novari.fint.model.utdanning.utdanningsprogram;

import static no.novari.fint.model.FintMultiplicity.NONE_TO_MANY;
import static no.novari.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.ONE_TO_MANY;

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
public class Programomrade extends Gruppe implements FintModelObject {
  @Getter
  public enum Relasjonsnavn implements FintRelation {
    GREPREFERANSE(
        "grepreferanse",
        "no.novari.fint.model.utdanning.kodeverk.Grepreferanse",
        NONE_TO_ONE,
        null,
        null),
    UTDANNINGSPROGRAM(
        "utdanningsprogram",
        "no.novari.fint.model.utdanning.utdanningsprogram.Utdanningsprogram",
        ONE_TO_MANY,
        true,
        "programomrade"),
    VIGOREFERANSE(
        "vigoreferanse",
        "no.novari.fint.model.utdanning.kodeverk.Vigoreferanse",
        NONE_TO_ONE,
        null,
        null),
    FAG("fag", "no.novari.fint.model.utdanning.timeplan.Fag", NONE_TO_MANY, false, "programomrade"),
    TRINN(
        "trinn",
        "no.novari.fint.model.utdanning.utdanningsprogram.Arstrinn",
        NONE_TO_MANY,
        false,
        "programomrade"),
    GRUPPEMEDLEMSKAP(
        "gruppemedlemskap",
        "no.novari.fint.model.utdanning.utdanningsprogram.Programomrademedlemskap",
        NONE_TO_MANY,
        false,
        "programomrade");

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
