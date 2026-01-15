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
public class Eksamensgruppemedlemskap extends Gruppemedlemskap implements FintModelObject {
  @Getter
  public enum Relasjonsnavn implements FintRelation {
    DELEGERTTIL("delegertTil", "no.novari.fint.model.felles.kodeverk.Fylke", NONE_TO_ONE, null),
    ELEVFORHOLD(
        "elevforhold",
        "no.novari.fint.model.utdanning.elev.Elevforhold",
        ONE_TO_ONE,
        "eksamensgruppemedlemskap"),
    FORETRUKKETSKOLE(
        "foretrukketSkole",
        "no.novari.fint.model.utdanning.utdanningsprogram.Skole",
        NONE_TO_ONE,
        null),
    EKSAMENSGRUPPE(
        "eksamensgruppe",
        "no.novari.fint.model.utdanning.vurdering.Eksamensgruppe",
        ONE_TO_ONE,
        "gruppemedlemskap"),
    NUS("nus", "no.novari.fint.model.utdanning.kodeverk.Karakterstatus", NONE_TO_ONE, null),
    BETALINGSSTATUS(
        "betalingsstatus",
        "no.novari.fint.model.utdanning.kodeverk.Betalingsstatus",
        NONE_TO_ONE,
        null),
    FORETRUKKETSENSOR(
        "foretrukketSensor", "no.novari.fint.model.utdanning.vurdering.Sensor", NONE_TO_ONE, null);

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
  private Boolean delegert;
  private String kandidatnummer;
}
