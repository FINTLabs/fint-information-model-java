package no.novari.fint.model.arkiv.noark;

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
import no.novari.fint.model.FintAbstractObject;
import no.novari.fint.model.FintIdentifikator;
import no.novari.fint.model.FintMultiplicity;
import no.novari.fint.model.FintRelation;
import no.novari.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class Mappe implements FintAbstractObject {
  @Getter
  public enum Relasjonsnavn implements FintRelation {
    ARKIVDEL("arkivdel", "no.novari.fint.model.arkiv.noark.Arkivdel", NONE_TO_ONE, null),
    AVSLUTTETAV("avsluttetAv", "no.novari.fint.model.arkiv.noark.Arkivressurs", NONE_TO_ONE, null),
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
  public Map<String, FintIdentifikator> getIdentifikators() {
    Map<String, FintIdentifikator> identifikators = new HashMap<>();
    identifikators.put("mappeId", this.mappeId);
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

  @JsonIgnore private final boolean writeable = true;
  @JsonIgnore private final List<FintRelation> relations = createRelations();
  private @Valid Date avsluttetDato;
  private String beskrivelse;
  private List<@Valid Klasse> klasse;
  private @Valid Identifikator mappeId;
  private List<@Valid Merknad> merknad;
  private List<String> noekkelord;
  private String offentligTittel;
  private @Valid Date opprettetDato;
  private List<@Valid Part> part;
  private @Valid Skjerming skjerming;
  private @Valid Identifikator systemId;
  private String tittel;
}
