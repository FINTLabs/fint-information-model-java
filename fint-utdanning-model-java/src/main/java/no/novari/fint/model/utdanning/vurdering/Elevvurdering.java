package no.novari.fint.model.utdanning.vurdering;

import static no.novari.fint.model.FintMultiplicity.NONE_TO_MANY;
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

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Elevvurdering implements FintModelObject {
  @Getter
  public enum Relasjonsnavn implements FintRelation {
    ELEVFORHOLD(
        "elevforhold",
        "no.novari.fint.model.utdanning.elev.Elevforhold",
        ONE_TO_ONE,
        true,
        "elevvurdering"),
    SLUTTFAGVURDERING(
        "sluttfagvurdering",
        "no.novari.fint.model.utdanning.vurdering.Sluttfagvurdering",
        NONE_TO_MANY,
        true,
        "elevvurdering"),
    UNDERVEISORDENSVURDERING(
        "underveisordensvurdering",
        "no.novari.fint.model.utdanning.vurdering.Underveisordensvurdering",
        NONE_TO_MANY,
        true,
        "elevvurdering"),
    VITNEMALSMERKNAD(
        "vitnemalsmerknad",
        "no.novari.fint.model.utdanning.kodeverk.Vitnemalsmerknad",
        NONE_TO_MANY,
        null,
        null),
    UNDERVEISFAGVURDERING(
        "underveisfagvurdering",
        "no.novari.fint.model.utdanning.vurdering.Underveisfagvurdering",
        NONE_TO_MANY,
        true,
        "elevvurdering"),
    HALVARSORDENSVURDERING(
        "halvarsordensvurdering",
        "no.novari.fint.model.utdanning.vurdering.Halvarsordensvurdering",
        NONE_TO_MANY,
        true,
        "elevvurdering"),
    HALVARSFAGVURDERING(
        "halvarsfagvurdering",
        "no.novari.fint.model.utdanning.vurdering.Halvarsfagvurdering",
        NONE_TO_MANY,
        true,
        "elevvurdering"),
    SLUTTORDENSVURDERING(
        "sluttordensvurdering",
        "no.novari.fint.model.utdanning.vurdering.Sluttordensvurdering",
        NONE_TO_MANY,
        true,
        "elevvurdering"),
    EKSAMENSVURDERING(
        "eksamensvurdering",
        "no.novari.fint.model.utdanning.vurdering.Eksamensvurdering",
        NONE_TO_MANY,
        false,
        "elevvurdering");

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
  @NotNull private @Valid Identifikator systemId;
}
