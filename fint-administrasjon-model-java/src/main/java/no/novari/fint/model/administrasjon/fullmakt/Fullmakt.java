package no.novari.fint.model.administrasjon.fullmakt;

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
public class Fullmakt implements FintModelObject {
  @Getter
  public enum Relasjonsnavn implements FintRelation {
    RAMME("ramme", "no.novari.fint.model.administrasjon.kodeverk.Ramme", NONE_TO_ONE, null, null),
    FUNKSJON(
        "funksjon",
        "no.novari.fint.model.administrasjon.kodeverk.Funksjon",
        NONE_TO_ONE,
        null,
        null),
    OBJEKT(
        "objekt", "no.novari.fint.model.administrasjon.kodeverk.Objekt", NONE_TO_ONE, null, null),
    ORGANISASJONSELEMENT(
        "organisasjonselement",
        "no.novari.fint.model.administrasjon.organisasjon.Organisasjonselement",
        NONE_TO_ONE,
        null,
        null),
    ART("art", "no.novari.fint.model.administrasjon.kodeverk.Art", NONE_TO_ONE, null, null),
    ANLEGG(
        "anlegg", "no.novari.fint.model.administrasjon.kodeverk.Anlegg", NONE_TO_ONE, null, null),
    DIVERSE(
        "diverse", "no.novari.fint.model.administrasjon.kodeverk.Diverse", NONE_TO_ONE, null, null),
    AKTIVITET(
        "aktivitet",
        "no.novari.fint.model.administrasjon.kodeverk.Aktivitet",
        NONE_TO_ONE,
        null,
        null),
    ANSVAR(
        "ansvar", "no.novari.fint.model.administrasjon.kodeverk.Ansvar", NONE_TO_ONE, null, null),
    STEDFORTREDER(
        "stedfortreder",
        "no.novari.fint.model.administrasjon.personal.Personalressurs",
        NONE_TO_ONE,
        true,
        "stedfortreder"),
    KONTRAKT(
        "kontrakt",
        "no.novari.fint.model.administrasjon.kodeverk.Kontrakt",
        NONE_TO_ONE,
        null,
        null),
    FULLMEKTIG(
        "fullmektig",
        "no.novari.fint.model.administrasjon.personal.Personalressurs",
        NONE_TO_ONE,
        true,
        "fullmakt"),
    PROSJEKT(
        "prosjekt",
        "no.novari.fint.model.administrasjon.kodeverk.Prosjekt",
        NONE_TO_ONE,
        null,
        null),
    FORMAL(
        "formal", "no.novari.fint.model.administrasjon.kodeverk.Formal", NONE_TO_ONE, null, null),
    ROLLE(
        "rolle",
        "no.novari.fint.model.administrasjon.fullmakt.Rolle",
        ONE_TO_ONE,
        true,
        "fullmakt"),
    LOPENUMMER(
        "lopenummer",
        "no.novari.fint.model.administrasjon.kodeverk.Lopenummer",
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
  @NotNull private @Valid Periode gyldighetsperiode;
  @NotNull private @Valid Identifikator systemId;
}
