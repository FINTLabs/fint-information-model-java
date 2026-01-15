package no.novari.fint.model.utdanning.vurdering;

import static no.novari.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.ONE_TO_ONE;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Arrays;
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
import no.novari.fint.model.FintModelObject;
import no.novari.fint.model.FintMultiplicity;
import no.novari.fint.model.FintRelation;
import no.novari.fint.model.felles.kompleksedatatyper.Identifikator;
import no.novari.fint.model.felles.kompleksedatatyper.Periode;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Fravarsregistrering implements FintModelObject {
  @Getter
  public enum Relasjonsnavn implements FintRelation {
    REGISTRERTAV(
        "registrertAv", "no.novari.fint.model.utdanning.elev.Skoleressurs", NONE_TO_ONE, null),
    FAGGRUPPE("faggruppe", "no.novari.fint.model.utdanning.timeplan.Faggruppe", NONE_TO_ONE, null),
    UNDERVISNINGSGRUPPE(
        "undervisningsgruppe",
        "no.novari.fint.model.utdanning.timeplan.Undervisningsgruppe",
        ONE_TO_ONE,
        null),
    FRAVARSTYPE(
        "fravarstype", "no.novari.fint.model.utdanning.kodeverk.Fravarstype", ONE_TO_ONE, null),
    ELEVFRAVAR(
        "elevfravar",
        "no.novari.fint.model.utdanning.vurdering.Elevfravar",
        ONE_TO_ONE,
        "fravarsregistrering");

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
    identifikators.put("systemId", this.systemId);

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
  @NotNull private Boolean foresPaVitnemal;
  private String kommentar;
  @NotNull private @Valid Periode periode;
  @NotNull private @Valid Identifikator systemId;
}
