package no.novari.fint.model.ressurs.eiendel;

import static no.novari.fint.model.FintMultiplicity.NONE_TO_MANY;
import static no.novari.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.ONE_TO_MANY;
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
public class Applikasjonsressurs implements FintModelObject {
  @Getter
  public enum Relasjonsnavn implements FintRelation {
    BRUKERTYPE("brukertype", "no.novari.fint.model.ressurs.kodeverk.Brukertype", ONE_TO_MANY, null),
    HANDHEVINGSTYPE(
        "handhevingstype",
        "no.novari.fint.model.ressurs.kodeverk.Handhevingstype",
        NONE_TO_ONE,
        null),
    LISENSMODELL(
        "lisensmodell", "no.novari.fint.model.ressurs.kodeverk.Lisensmodell", NONE_TO_ONE, null),
    RESSURSTILGJENGELIGHET(
        "ressurstilgjengelighet",
        "no.novari.fint.model.ressurs.eiendel.Applikasjonsressurstilgjengelighet",
        NONE_TO_MANY,
        "ressurs"),
    EIER(
        "eier",
        "no.novari.fint.model.administrasjon.organisasjon.Organisasjonselement",
        ONE_TO_ONE,
        null),
    APPLIKASJON(
        "applikasjon", "no.novari.fint.model.ressurs.eiendel.Applikasjon", ONE_TO_ONE, "ressurs");

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
  private String beskrivelse;
  private Long enhetskostnad;
  @NotNull private @Valid Periode gyldighetsperiode;
  private Boolean kreverGodkjenning;
  private Long lisensantall;
  @NotBlank private String navn;
  @NotNull private @Valid Identifikator systemId;
}
