package no.novari.fint.model.utdanning.utdanningsprogram;

import static no.novari.fint.model.FintMultiplicity.NONE_TO_MANY;
import static no.novari.fint.model.FintMultiplicity.NONE_TO_ONE;

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
import no.novari.fint.model.felles.basisklasser.Enhet;
import no.novari.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Skole extends Enhet implements FintModelObject {
  @Getter
  public enum Relasjonsnavn implements FintRelation {
    ORGANISASJON(
        "organisasjon",
        "no.novari.fint.model.administrasjon.organisasjon.Organisasjonselement",
        NONE_TO_ONE,
        true,
        "skole"),
    FAG("fag", "no.novari.fint.model.utdanning.timeplan.Fag", NONE_TO_MANY, true, "skole"),
    SKOLEEIERTYPE(
        "skoleeierType",
        "no.novari.fint.model.utdanning.kodeverk.Skoleeiertype",
        NONE_TO_ONE,
        null,
        null),
    VIGOREFERANSE(
        "vigoreferanse",
        "no.novari.fint.model.utdanning.kodeverk.Vigoreferanse",
        NONE_TO_ONE,
        null,
        null),
    ELEVFORHOLD(
        "elevforhold",
        "no.novari.fint.model.utdanning.elev.Elevforhold",
        NONE_TO_MANY,
        false,
        "skole"),
    KLASSE("klasse", "no.novari.fint.model.utdanning.elev.Klasse", NONE_TO_MANY, false, "skole"),
    KONTAKTLARERGRUPPE(
        "kontaktlarergruppe",
        "no.novari.fint.model.utdanning.elev.Kontaktlarergruppe",
        NONE_TO_MANY,
        false,
        "skole"),
    SKOLERESSURS(
        "skoleressurs",
        "no.novari.fint.model.utdanning.elev.Skoleressurs",
        NONE_TO_MANY,
        false,
        "skole"),
    UNDERVISNINGSFORHOLD(
        "undervisningsforhold",
        "no.novari.fint.model.utdanning.elev.Undervisningsforhold",
        NONE_TO_MANY,
        false,
        "skole"),
    FAGGRUPPE(
        "faggruppe",
        "no.novari.fint.model.utdanning.timeplan.Faggruppe",
        NONE_TO_MANY,
        false,
        "skole"),
    UNDERVISNINGSGRUPPE(
        "undervisningsgruppe",
        "no.novari.fint.model.utdanning.timeplan.Undervisningsgruppe",
        NONE_TO_MANY,
        false,
        "skole"),
    EKSAMENSGRUPPE(
        "eksamensgruppe",
        "no.novari.fint.model.utdanning.vurdering.Eksamensgruppe",
        NONE_TO_MANY,
        false,
        "skole"),
    UTDANNINGSPROGRAM(
        "utdanningsprogram",
        "no.novari.fint.model.utdanning.utdanningsprogram.Utdanningsprogram",
        NONE_TO_MANY,
        false,
        "skole");

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
    identifikators.put("skolenummer", this.skolenummer);
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
  private String domenenavn;
  private String juridiskNavn;
  @NotBlank private String navn;
  @NotNull private @Valid Identifikator skolenummer;
  @NotNull private @Valid Identifikator systemId;
}
