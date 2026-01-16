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
import no.novari.fint.model.FintComplexDatatypeObject;
import no.novari.fint.model.FintMultiplicity;
import no.novari.fint.model.FintRelation;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Journalpost extends Registrering implements FintComplexDatatypeObject {
  @Getter
  public enum Relasjonsnavn implements FintRelation {
    JOURNALPOSTTYPE(
        "journalposttype", "no.novari.fint.model.arkiv.kodeverk.JournalpostType", ONE_TO_ONE, null),
    JOURNALSTATUS(
        "journalstatus", "no.novari.fint.model.arkiv.kodeverk.JournalStatus", ONE_TO_ONE, null),
    JOURNALENHET(
        "journalenhet", "no.novari.fint.model.arkiv.noark.AdministrativEnhet", NONE_TO_ONE, null);

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
    relations.addAll(super.getRelations());

    relations.addAll(Arrays.asList(Relasjonsnavn.values()));

    return Collections.unmodifiableList(relations);
  }

  public boolean isWriteable() {
    return this.writeable;
  }

  @JsonIgnore private final boolean writeable = true;
  @JsonIgnore private final List<FintRelation> relations = createRelations();
  private Long antallVedlegg;
  private @Valid Avskrivning avskrivning;
  private @Valid Date dokumentetsDato;
  private @Valid Date forfallsDato;
  private String journalAr;
  private @Valid Date journalDato;
  private Long journalPostnummer;
  private Long journalSekvensnummer;
  private @Valid Date mottattDato;
  private @Valid Date offentlighetsvurdertDato;
  private @Valid Date sendtDato;
}
