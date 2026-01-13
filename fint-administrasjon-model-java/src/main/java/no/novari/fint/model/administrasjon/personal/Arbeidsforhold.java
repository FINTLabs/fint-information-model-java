package no.novari.fint.model.administrasjon.personal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.novari.fint.model.FintMultiplicity;
import no.novari.fint.model.felles.kompleksedatatyper.Identifikator;
import no.novari.fint.model.FintModelObject;
import no.novari.fint.model.FintIdentifikator;
import no.novari.fint.model.FintRelation;
import no.novari.fint.model.felles.kompleksedatatyper.Periode;

import static no.novari.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.novari.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Arbeidsforhold  implements FintModelObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
        AKTIVITET("aktivitet", "no.novari.fint.model.administrasjon.kodeverk.Aktivitet", NONE_TO_ONE),
        ANLEGG("anlegg", "no.novari.fint.model.administrasjon.kodeverk.Anlegg", NONE_TO_ONE),
        ANSVAR("ansvar", "no.novari.fint.model.administrasjon.kodeverk.Ansvar", NONE_TO_ONE),
        ARBEIDSFORHOLDSTYPE("arbeidsforholdstype", "no.novari.fint.model.administrasjon.kodeverk.Arbeidsforholdstype", NONE_TO_ONE),
        ART("art", "no.novari.fint.model.administrasjon.kodeverk.Art", NONE_TO_ONE),
        DIVERSE("diverse", "no.novari.fint.model.administrasjon.kodeverk.Diverse", NONE_TO_ONE),
        FORMAL("formal", "no.novari.fint.model.administrasjon.kodeverk.Formal", NONE_TO_ONE),
        FUNKSJON("funksjon", "no.novari.fint.model.administrasjon.kodeverk.Funksjon", NONE_TO_ONE),
        KONTRAKT("kontrakt", "no.novari.fint.model.administrasjon.kodeverk.Kontrakt", NONE_TO_ONE),
        LOPENUMMER("lopenummer", "no.novari.fint.model.administrasjon.kodeverk.Lopenummer", NONE_TO_ONE),
        OBJEKT("objekt", "no.novari.fint.model.administrasjon.kodeverk.Objekt", NONE_TO_ONE),
        PROSJEKT("prosjekt", "no.novari.fint.model.administrasjon.kodeverk.Prosjekt", NONE_TO_ONE),
        RAMME("ramme", "no.novari.fint.model.administrasjon.kodeverk.Ramme", NONE_TO_ONE),
        STILLINGSKODE("stillingskode", "no.novari.fint.model.administrasjon.kodeverk.Stillingskode", NONE_TO_ONE),
        TIMERPERUKE("timerPerUke", "no.novari.fint.model.administrasjon.kodeverk.Uketimetall", NONE_TO_ONE),
        ARBEIDSLOKASJON("arbeidslokasjon", "no.novari.fint.model.administrasjon.organisasjon.Arbeidslokasjon", NONE_TO_ONE),
        ARBEIDSSTED("arbeidssted", "no.novari.fint.model.administrasjon.organisasjon.Organisasjonselement", ONE_TO_ONE),
        PERSONALLEDER("personalleder", "no.novari.fint.model.administrasjon.personal.Personalressurs", NONE_TO_ONE),
        FASTLONN("fastlonn", "no.novari.fint.model.administrasjon.personal.Fastlonn", NONE_TO_MANY),
        FASTTILLEGG("fasttillegg", "no.novari.fint.model.administrasjon.personal.Fasttillegg", NONE_TO_MANY),
        FRAVAR("fravar", "no.novari.fint.model.administrasjon.personal.Fravar", NONE_TO_MANY),
        LONN("lonn", "no.novari.fint.model.administrasjon.personal.Lonn", NONE_TO_MANY),
        VARIABELLONN("variabellonn", "no.novari.fint.model.administrasjon.personal.Variabellonn", NONE_TO_MANY),
        PERSONALRESSURS("personalressurs", "no.novari.fint.model.administrasjon.personal.Personalressurs", ONE_TO_ONE),
        UNDERVISNINGSFORHOLD("undervisningsforhold", "no.novari.fint.model.utdanning.elev.Undervisningsforhold", NONE_TO_ONE);
    
        private final String name;
        private final String packageName;
        private final FintMultiplicity multiplicity;

        private Relasjonsnavn(String name, String packageName, FintMultiplicity multiplicity) {
            this.name = name;
            this.packageName = packageName;
            this.multiplicity = multiplicity;
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

    @JsonIgnore
    private final boolean writeable = true;
    @JsonIgnore
    private final List<FintRelation> relations = createRelations();
    @NotNull
    private Long ansettelsesprosent;
    private @Valid Periode arbeidsforholdsperiode;
    @NotNull
    private Long arslonn;
    @NotNull
    private @Valid Periode gyldighetsperiode;
    @NotNull
    private Boolean hovedstilling;
    @NotNull
    private Long lonnsprosent;
    @NotBlank
    private String stillingsnummer;
    private String stillingstittel;
    @NotNull
    private @Valid Identifikator systemId;
    @NotNull
    private Long tilstedeprosent;
}
