package no.novari.fint.model.arkiv.noark;

import static no.novari.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.ONE_TO_ONE;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import no.novari.fint.model.FintAbstractObject;
import no.novari.fint.model.FintMultiplicity;
import no.novari.fint.model.FintRelation;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class Registrering implements FintAbstractObject {
  @Getter
  public enum Relasjonsnavn implements FintRelation {
    TILGANGSGRUPPE(
        "tilgangsgruppe",
        "no.novari.fint.model.arkiv.kodeverk.Tilgangsgruppe",
        NONE_TO_ONE,
        null,
        null),
    ADMINISTRATIVENHET(
        "administrativEnhet",
        "no.novari.fint.model.arkiv.noark.AdministrativEnhet",
        NONE_TO_ONE,
        null,
        null),
    ARKIVDEL("arkivdel", "no.novari.fint.model.arkiv.noark.Arkivdel", NONE_TO_ONE, null, null),
    SAKSBEHANDLER(
        "saksbehandler", "no.novari.fint.model.arkiv.noark.Arkivressurs", NONE_TO_ONE, null, null),
    ARKIVERTAV(
        "arkivertAv", "no.novari.fint.model.arkiv.noark.Arkivressurs", ONE_TO_ONE, null, null),
    OPPRETTETAV(
        "opprettetAv", "no.novari.fint.model.arkiv.noark.Arkivressurs", ONE_TO_ONE, null, null);

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

  @JsonIgnore private final boolean writeable = true;
  @JsonIgnore private final List<FintRelation> relations = createRelations();
  private @Valid Date arkivertDato;
  private String beskrivelse;
  private List<@Valid Dokumentbeskrivelse> dokumentbeskrivelse;
  private List<String> forfatter;
  private @Valid Klasse klasse;
  private List<@Valid Korrespondansepart> korrespondansepart;
  private List<@Valid Merknad> merknad;
  private List<String> nokkelord;
  private String offentligTittel;
  private @Valid Date opprettetDato;
  private List<@Valid Part> part;
  private List<String> referanseArkivDel;
  private String registreringsId;
  private @Valid Skjerming skjerming;
  @NotBlank private String tittel;
}
