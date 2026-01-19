package no.novari.fint.model.okonomi.faktura;

import static no.novari.fint.model.FintMultiplicity.NONE_TO_MANY;
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
public class Fakturagrunnlag implements FintModelObject {
  @Getter
  public enum Relasjonsnavn implements FintRelation {
    FAKTURA(
        "faktura",
        "no.novari.fint.model.okonomi.faktura.Faktura",
        NONE_TO_MANY,
        true,
        "fakturagrunnlag"),
    FAKTURAUTSTEDER(
        "fakturautsteder",
        "no.novari.fint.model.okonomi.faktura.Fakturautsteder",
        ONE_TO_ONE,
        true,
        "fakturagrunnlag");

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
    identifikators.put("ordrenummer", this.ordrenummer);

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
  private Long avgiftsbelop;
  @NotEmpty private List<@Valid Fakturalinje> fakturalinjer;
  private Date leveringsdato;
  @NotNull private @Valid Fakturamottaker mottaker;
  private Long nettobelop;
  @NotNull private @Valid Identifikator ordrenummer;
  private Long totalbelop;
}
