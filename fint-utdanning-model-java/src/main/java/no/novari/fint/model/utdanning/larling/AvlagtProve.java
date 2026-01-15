package no.novari.fint.model.utdanning.larling;

import static no.novari.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.ONE_TO_ONE;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
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

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AvlagtProve implements FintModelObject {
  @Getter
  public enum Relasjonsnavn implements FintRelation {
    PROVESTATUS(
        "provestatus", "no.novari.fint.model.utdanning.kodeverk.Provestatus", NONE_TO_ONE, null),
    LARLING("larling", "no.novari.fint.model.utdanning.larling.Larling", ONE_TO_ONE, "avlagtprove"),
    FULLFORTKODE(
        "fullfortkode", "no.novari.fint.model.utdanning.kodeverk.Fullfortkode", NONE_TO_ONE, null),
    BREVTYPE("brevtype", "no.novari.fint.model.utdanning.kodeverk.Brevtype", NONE_TO_ONE, null),
    BEVISTYPE("bevistype", "no.novari.fint.model.utdanning.kodeverk.Bevistype", NONE_TO_ONE, null);

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
  private Date provedato;
  @NotNull private @Valid Identifikator systemId;
}
