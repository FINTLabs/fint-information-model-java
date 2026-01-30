package no.novari.fint.model.utdanning.elev;

import static no.novari.fint.model.FintMultiplicity.NONE_TO_MANY;
import static no.novari.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.ONE_TO_MANY;
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
import no.novari.fint.model.utdanning.basisklasser.Gruppe;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Kontaktlarergruppe extends Gruppe implements FintModelObject {
  @Getter
  public enum Relasjonsnavn implements FintRelation {
    KLASSE(
        "klasse",
        "no.novari.fint.model.utdanning.elev.Klasse",
        ONE_TO_MANY,
        true,
        "kontaktlarergruppe"),
    TERMIN("termin", "no.novari.fint.model.utdanning.kodeverk.Termin", NONE_TO_MANY, null, null),
    SKOLE(
        "skole",
        "no.novari.fint.model.utdanning.utdanningsprogram.Skole",
        ONE_TO_ONE,
        true,
        "kontaktlarergruppe"),
    SKOLEAR("skolear", "no.novari.fint.model.utdanning.kodeverk.Skolear", NONE_TO_ONE, null, null),
    UNDERVISNINGSFORHOLD(
        "undervisningsforhold",
        "no.novari.fint.model.utdanning.elev.Undervisningsforhold",
        NONE_TO_MANY,
        true,
        "kontaktlarergruppe"),
    GRUPPEMEDLEMSKAP(
        "gruppemedlemskap",
        "no.novari.fint.model.utdanning.elev.Kontaktlarergruppemedlemskap",
        NONE_TO_MANY,
        false,
        "kontaktlarergruppe");

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
