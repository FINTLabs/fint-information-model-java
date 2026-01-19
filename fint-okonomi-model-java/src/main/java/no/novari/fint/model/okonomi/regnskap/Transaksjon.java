package no.novari.fint.model.okonomi.regnskap;

import static no.novari.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.ONE_TO_MANY;
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
public class Transaksjon implements FintModelObject {
  @Getter
  public enum Relasjonsnavn implements FintRelation {
    LEVERANDOR(
        "leverandor", "no.novari.fint.model.okonomi.regnskap.Leverandor", NONE_TO_ONE, null, null),
    ANSVARLIG(
        "ansvarlig",
        "no.novari.fint.model.administrasjon.personal.Personalressurs",
        NONE_TO_ONE,
        null,
        null),
    VALUTA("valuta", "no.novari.fint.model.felles.kodeverk.Valuta", ONE_TO_ONE, null, null),
    POSTERING(
        "postering",
        "no.novari.fint.model.okonomi.regnskap.Postering",
        ONE_TO_MANY,
        false,
        "transaksjon");

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
    identifikators.put("transaksjonsId", this.transaksjonsId);

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
  @NotNull private Long belop;
  private String beskrivelse;
  private List<@Valid Bilag> bilag;
  @NotNull private Date forfallsdato;
  private Date oppdateringstidspunkt;
  @NotNull private @Valid Identifikator transaksjonsId;
  private Date transaksjonstidspunkt;
}
