package no.novari.fint.model.utdanning.elev;

import static no.novari.fint.model.FintMultiplicity.NONE_TO_MANY;
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
import no.novari.fint.model.felles.kompleksedatatyper.Periode;
import no.novari.fint.model.utdanning.basisklasser.Utdanningsforhold;
import no.novari.fint.model.utdanning.vurdering.Anmerkninger;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Elevforhold extends Utdanningsforhold implements FintModelObject {
  @Getter
  public enum Relasjonsnavn implements FintRelation {
    ELEV("elev", "no.novari.fint.model.utdanning.elev.Elev", ONE_TO_ONE, "elevforhold"),
    KATEGORI("kategori", "no.novari.fint.model.utdanning.kodeverk.Elevkategori", NONE_TO_ONE, null),
    SKOLE(
        "skole",
        "no.novari.fint.model.utdanning.utdanningsprogram.Skole",
        ONE_TO_ONE,
        "elevforhold"),
    AVBRUDDSARSAK(
        "avbruddsarsak",
        "no.novari.fint.model.utdanning.kodeverk.Avbruddsarsak",
        NONE_TO_MANY,
        null),
    FRAVARSREGISTRERINGER(
        "fravarsregistreringer",
        "no.novari.fint.model.utdanning.vurdering.Elevfravar",
        NONE_TO_ONE,
        "elevforhold"),
    FAGGRUPPEMEDLEMSKAP(
        "faggruppemedlemskap",
        "no.novari.fint.model.utdanning.timeplan.Faggruppemedlemskap",
        NONE_TO_MANY,
        null),
    SKOLEAR("skolear", "no.novari.fint.model.utdanning.kodeverk.Skolear", NONE_TO_ONE, null),
    UNDERVISNINGSGRUPPEMEDLEMSKAP(
        "undervisningsgruppemedlemskap",
        "no.novari.fint.model.utdanning.timeplan.Undervisningsgruppemedlemskap",
        NONE_TO_MANY,
        "elevforhold"),
    PERSONGRUPPEMEDLEMSKAP(
        "persongruppemedlemskap",
        "no.novari.fint.model.utdanning.elev.Persongruppemedlemskap",
        NONE_TO_MANY,
        "elevforhold"),
    EKSAMENSGRUPPEMEDLEMSKAP(
        "eksamensgruppemedlemskap",
        "no.novari.fint.model.utdanning.vurdering.Eksamensgruppemedlemskap",
        NONE_TO_MANY,
        "elevforhold"),
    KONTAKTLARERGRUPPEMEDLEMSKAP(
        "kontaktlarergruppemedlemskap",
        "no.novari.fint.model.utdanning.elev.Kontaktlarergruppemedlemskap",
        NONE_TO_MANY,
        "elevforhold"),
    ELEVFRAVAR(
        "elevfravar",
        "no.novari.fint.model.utdanning.vurdering.Fravarsoversikt",
        NONE_TO_MANY,
        "elevforhold"),
    TILRETTELEGGING(
        "tilrettelegging",
        "no.novari.fint.model.utdanning.elev.Elevtilrettelegging",
        NONE_TO_MANY,
        "elev"),
    ELEVVURDERING(
        "elevvurdering",
        "no.novari.fint.model.utdanning.vurdering.Elevvurdering",
        NONE_TO_ONE,
        "elevforhold"),
    PROGRAMOMRADEMEDLEMSKAP(
        "programomrademedlemskap",
        "no.novari.fint.model.utdanning.utdanningsprogram.Programomrademedlemskap",
        NONE_TO_MANY,
        "elevforhold"),
    KLASSEMEDLEMSKAP(
        "klassemedlemskap",
        "no.novari.fint.model.utdanning.elev.Klassemedlemskap",
        NONE_TO_MANY,
        "elevforhold");

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
  private List<@Valid Anmerkninger> anmerkninger;
  private Date avbruddsdato;
  private @Valid Periode gyldighetsperiode;
  private Boolean hovedskole;
  private Boolean tosprakligFagopplaring;
}
