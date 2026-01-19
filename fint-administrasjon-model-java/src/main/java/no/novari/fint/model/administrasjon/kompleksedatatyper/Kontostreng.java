package no.novari.fint.model.administrasjon.kompleksedatatyper;

import static no.novari.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.ONE_TO_ONE;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import no.novari.fint.model.FintComplexDatatypeObject;
import no.novari.fint.model.FintMultiplicity;
import no.novari.fint.model.FintRelation;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Kontostreng implements FintComplexDatatypeObject {
  @Getter
  public enum Relasjonsnavn implements FintRelation {
    AKTIVITET(
        "aktivitet",
        "no.novari.fint.model.administrasjon.kodeverk.Aktivitet",
        NONE_TO_ONE,
        null,
        null),
    ANLEGG(
        "anlegg", "no.novari.fint.model.administrasjon.kodeverk.Anlegg", NONE_TO_ONE, null, null),
    ANSVAR("ansvar", "no.novari.fint.model.administrasjon.kodeverk.Ansvar", ONE_TO_ONE, null, null),
    ART("art", "no.novari.fint.model.administrasjon.kodeverk.Art", ONE_TO_ONE, null, null),
    DIVERSE(
        "diverse", "no.novari.fint.model.administrasjon.kodeverk.Diverse", NONE_TO_ONE, null, null),
    FORMAL(
        "formal", "no.novari.fint.model.administrasjon.kodeverk.Formal", NONE_TO_ONE, null, null),
    FUNKSJON(
        "funksjon",
        "no.novari.fint.model.administrasjon.kodeverk.Funksjon",
        ONE_TO_ONE,
        null,
        null),
    KONTRAKT(
        "kontrakt",
        "no.novari.fint.model.administrasjon.kodeverk.Kontrakt",
        NONE_TO_ONE,
        null,
        null),
    LOPENUMMER(
        "lopenummer",
        "no.novari.fint.model.administrasjon.kodeverk.Lopenummer",
        NONE_TO_ONE,
        null,
        null),
    OBJEKT(
        "objekt", "no.novari.fint.model.administrasjon.kodeverk.Objekt", NONE_TO_ONE, null, null),
    PROSJEKT(
        "prosjekt",
        "no.novari.fint.model.administrasjon.kodeverk.Prosjekt",
        NONE_TO_ONE,
        null,
        null),
    PROSJEKTART(
        "prosjektart",
        "no.novari.fint.model.administrasjon.kodeverk.Prosjektart",
        NONE_TO_ONE,
        null,
        null),
    RAMME("ramme", "no.novari.fint.model.administrasjon.kodeverk.Ramme", NONE_TO_ONE, null, null);

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
}
