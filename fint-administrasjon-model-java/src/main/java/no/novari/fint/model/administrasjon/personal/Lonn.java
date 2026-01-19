package no.novari.fint.model.administrasjon.personal;

import static no.novari.fint.model.FintMultiplicity.NONE_TO_ONE;

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
import no.novari.fint.model.FintAbstractObject;
import no.novari.fint.model.FintIdentifikator;
import no.novari.fint.model.FintMultiplicity;
import no.novari.fint.model.FintRelation;
import no.novari.fint.model.administrasjon.kompleksedatatyper.Kontostreng;
import no.novari.fint.model.felles.kompleksedatatyper.Identifikator;
import no.novari.fint.model.felles.kompleksedatatyper.Periode;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class Lonn implements FintAbstractObject {
  @Getter
  public enum Relasjonsnavn implements FintRelation {
    ANVISER(
        "anviser",
        "no.novari.fint.model.administrasjon.personal.Personalressurs",
        NONE_TO_ONE,
        null,
        null),
    KONTERER(
        "konterer",
        "no.novari.fint.model.administrasjon.personal.Personalressurs",
        NONE_TO_ONE,
        null,
        null),
    ATTESTANT(
        "attestant",
        "no.novari.fint.model.administrasjon.personal.Personalressurs",
        NONE_TO_ONE,
        null,
        null);

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
    identifikators.put("kildesystemId", this.kildesystemId);
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

  @JsonIgnore private final boolean writeable = true;
  @JsonIgnore private final List<FintRelation> relations = createRelations();
  private @Valid Date anvist;
  private @Valid Date attestert;
  @NotBlank private String beskrivelse;
  private @Valid Identifikator kildesystemId;
  private @Valid Date kontert;
  @NotNull private @Valid Kontostreng kontostreng;
  private @Valid Periode opptjent;
  @NotNull private @Valid Periode periode;
  private @Valid Identifikator systemId;
}
