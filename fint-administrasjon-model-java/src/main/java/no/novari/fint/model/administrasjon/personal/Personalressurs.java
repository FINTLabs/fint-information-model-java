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
import no.fint.model.FintMultiplicity;
import no.novari.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.FintModelObject;
import no.fint.model.FintIdentifikator;
import no.fint.model.FintRelation;
import no.novari.fint.model.felles.kompleksedatatyper.Periode;
import java.util.Date;
import no.novari.fint.model.felles.kompleksedatatyper.Kontaktinformasjon;

import static no.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Personalressurs  implements FintModelObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
        PERSONALRESSURSKATEGORI("personalressurskategori", "no.fint.model.administrasjon.kodeverk.Personalressurskategori", ONE_TO_ONE),
        ARBEIDSFORHOLD("arbeidsforhold", "no.fint.model.administrasjon.personal.Arbeidsforhold", NONE_TO_MANY),
        PERSON("person", "no.fint.model.felles.Person", ONE_TO_ONE),
        STEDFORTREDER("stedfortreder", "no.fint.model.administrasjon.fullmakt.Fullmakt", NONE_TO_MANY),
        FULLMAKT("fullmakt", "no.fint.model.administrasjon.fullmakt.Fullmakt", NONE_TO_MANY),
        LEDER("leder", "no.fint.model.administrasjon.organisasjon.Organisasjonselement", NONE_TO_MANY),
        PERSONALANSVAR("personalansvar", "no.fint.model.administrasjon.personal.Arbeidsforhold", NONE_TO_MANY),
        SKOLERESSURS("skoleressurs", "no.fint.model.utdanning.elev.Skoleressurs", NONE_TO_ONE);
    
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
        identifikators.put("ansattnummer", this.ansattnummer);
        identifikators.put("brukernavn", this.brukernavn);
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
    private @Valid Identifikator ansattnummer;
    @NotNull
    private @Valid Periode ansettelsesperiode;
    private Date ansiennitet;
    private @Valid Identifikator brukernavn;
    private String jobbtittel;
    private @Valid Kontaktinformasjon kontaktinformasjon;
    private @Valid Identifikator systemId;
}
