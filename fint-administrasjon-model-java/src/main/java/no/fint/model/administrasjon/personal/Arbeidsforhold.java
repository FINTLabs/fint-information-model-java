package no.fint.model.administrasjon.personal;

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
import no.fint.model.FintMultiplicity;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.FintModelObject;
import no.fint.model.FintIdentifikator;
import no.fint.model.FintRelation;
import no.fint.model.felles.kompleksedatatyper.Periode;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

import static no.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Arbeidsforhold  implements FintModelObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
        AKTIVITET("aktivitet", "no.fint.model.administrasjon.kodeverk.Aktivitet", NONE_TO_ONE, null),
        ANLEGG("anlegg", "no.fint.model.administrasjon.kodeverk.Anlegg", NONE_TO_ONE, null),
        ANSVAR("ansvar", "no.fint.model.administrasjon.kodeverk.Ansvar", NONE_TO_ONE, null),
        ARBEIDSFORHOLDSTYPE("arbeidsforholdstype", "no.fint.model.administrasjon.kodeverk.Arbeidsforholdstype", NONE_TO_ONE, null),
        ART("art", "no.fint.model.administrasjon.kodeverk.Art", NONE_TO_ONE, null),
        DIVERSE("diverse", "no.fint.model.administrasjon.kodeverk.Diverse", NONE_TO_ONE, null),
        FORMAL("formal", "no.fint.model.administrasjon.kodeverk.Formal", NONE_TO_ONE, null),
        FUNKSJON("funksjon", "no.fint.model.administrasjon.kodeverk.Funksjon", NONE_TO_ONE, null),
        KONTRAKT("kontrakt", "no.fint.model.administrasjon.kodeverk.Kontrakt", NONE_TO_ONE, null),
        LOPENUMMER("lopenummer", "no.fint.model.administrasjon.kodeverk.Lopenummer", NONE_TO_ONE, null),
        OBJEKT("objekt", "no.fint.model.administrasjon.kodeverk.Objekt", NONE_TO_ONE, null),
        PROSJEKT("prosjekt", "no.fint.model.administrasjon.kodeverk.Prosjekt", NONE_TO_ONE, null),
        RAMME("ramme", "no.fint.model.administrasjon.kodeverk.Ramme", NONE_TO_ONE, null),
        STILLINGSKODE("stillingskode", "no.fint.model.administrasjon.kodeverk.Stillingskode", NONE_TO_ONE, null),
        TIMERPERUKE("timerPerUke", "no.fint.model.administrasjon.kodeverk.Uketimetall", NONE_TO_ONE, null),
        ARBEIDSLOKASJON("arbeidslokasjon", "no.fint.model.administrasjon.organisasjon.Arbeidslokasjon", NONE_TO_ONE, "arbeidsforhold"),
        ARBEIDSSTED("arbeidssted", "no.fint.model.administrasjon.organisasjon.Organisasjonselement", ONE_TO_ONE, "arbeidsforhold"),
        PERSONALLEDER("personalleder", "no.fint.model.administrasjon.personal.Personalressurs", NONE_TO_ONE, "personalansvar"),
        FASTLONN("fastlonn", "no.fint.model.administrasjon.personal.Fastlonn", NONE_TO_MANY, "arbeidsforhold"),
        FASTTILLEGG("fasttillegg", "no.fint.model.administrasjon.personal.Fasttillegg", NONE_TO_MANY, "arbeidsforhold"),
        FRAVAR("fravar", "no.fint.model.administrasjon.personal.Fravar", NONE_TO_MANY, "arbeidsforhold"),
        LONN("lonn", "no.fint.model.administrasjon.personal.Lonn", NONE_TO_MANY, null),
        VARIABELLONN("variabellonn", "no.fint.model.administrasjon.personal.Variabellonn", NONE_TO_MANY, "arbeidsforhold"),
        PERSONALRESSURS("personalressurs", "no.fint.model.administrasjon.personal.Personalressurs", ONE_TO_ONE, "arbeidsforhold"),
        UNDERVISNINGSFORHOLD("undervisningsforhold", "no.fint.model.utdanning.elev.Undervisningsforhold", NONE_TO_ONE, "arbeidsforhold");
    
        private final String name;
        private final String packageName;
        private final FintMultiplicity multiplicity;
        private final String inverseName;

        private Relasjonsnavn(String name, String packageName, FintMultiplicity multiplicity, String inverseName) {
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
