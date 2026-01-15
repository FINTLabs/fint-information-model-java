package no.novari.fint.model.arkiv.noark;

import static no.novari.fint.model.FintMultiplicity.ONE_TO_MANY;
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
import no.novari.fint.model.FintComplexDatatypeObject;
import no.novari.fint.model.FintMultiplicity;
import no.novari.fint.model.FintRelation;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Dokumentbeskrivelse implements FintComplexDatatypeObject {
  @Getter
  public enum Relasjonsnavn implements FintRelation {
    DOKUMENTSTATUS(
        "dokumentstatus", "no.novari.fint.model.arkiv.kodeverk.DokumentStatus", ONE_TO_ONE, null),
    DOKUMENTTYPE(
        "dokumentType", "no.novari.fint.model.arkiv.kodeverk.DokumentType", ONE_TO_ONE, null),
    TILKNYTTETREGISTRERINGSOM(
        "tilknyttetRegistreringSom",
        "no.novari.fint.model.arkiv.kodeverk.TilknyttetRegistreringSom",
        ONE_TO_MANY,
        null),
    TILKNYTTETAV("tilknyttetAv", "no.novari.fint.model.arkiv.noark.Arkivressurs", ONE_TO_ONE, null),
    OPPRETTETAV("opprettetAv", "no.novari.fint.model.arkiv.noark.Arkivressurs", ONE_TO_ONE, null);

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
  private String beskrivelse;
  private Long dokumentnummer;
  private List<@Valid Dokumentobjekt> dokumentobjekt;
  private List<String> forfatter;
  private @Valid Date opprettetDato;
  private List<@Valid Part> part;
  private List<String> referanseArkivdel;
  private @Valid Skjerming skjerming;
  private @Valid Date tilknyttetDato;
  @NotBlank private String tittel;
}
