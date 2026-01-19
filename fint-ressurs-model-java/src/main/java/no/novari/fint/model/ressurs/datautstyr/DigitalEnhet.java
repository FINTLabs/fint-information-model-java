package no.novari.fint.model.ressurs.datautstyr;

import static no.novari.fint.model.FintMultiplicity.NONE_TO_MANY;
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

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class DigitalEnhet implements FintModelObject {
  @Getter
  public enum Relasjonsnavn implements FintRelation {
    ADMINISTRATOR(
        "administrator",
        "no.novari.fint.model.administrasjon.organisasjon.Organisasjonselement",
        ONE_TO_ONE,
        null,
        null),
    EIER(
        "eier",
        "no.novari.fint.model.administrasjon.organisasjon.Organisasjonselement",
        NONE_TO_ONE,
        null,
        null),
    PERSONALRESSURS(
        "personalressurs",
        "no.novari.fint.model.administrasjon.personal.Personalressurs",
        NONE_TO_ONE,
        null,
        null),
    ELEV("elev", "no.novari.fint.model.utdanning.elev.Elev", NONE_TO_ONE, null, null),
    STATUS("status", "no.novari.fint.model.ressurs.kodeverk.Status", NONE_TO_ONE, null, null),
    ENHETSTYPE(
        "enhetstype", "no.novari.fint.model.ressurs.kodeverk.Enhetstype", ONE_TO_ONE, null, null),
    PLATTFORM(
        "plattform", "no.novari.fint.model.ressurs.kodeverk.Plattform", ONE_TO_ONE, null, null),
    PRODUSENT(
        "produsent", "no.novari.fint.model.ressurs.kodeverk.Produsent", NONE_TO_ONE, null, null),
    ENHETSGRUPPEMEDLEMSKAP(
        "enhetsgruppemedlemskap",
        "no.novari.fint.model.ressurs.datautstyr.Enhetsgruppemedlemskap",
        NONE_TO_MANY,
        false,
        "digitalEnhet");

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
    identifikators.put("dataobjektId", this.dataobjektId);
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
  private @Valid Identifikator dataobjektId;
  private Boolean flerbrukerenhet;
  private String navn;
  private Boolean privateid;
  @NotBlank private String serienummer;
  @NotNull private @Valid Identifikator systemId;
}
