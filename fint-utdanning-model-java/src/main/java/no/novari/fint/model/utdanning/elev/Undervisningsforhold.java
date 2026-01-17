package no.novari.fint.model.utdanning.elev;

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
import no.novari.fint.model.FintModelObject;
import no.novari.fint.model.FintIdentifikator;
import no.novari.fint.model.FintRelation;
import no.novari.fint.model.utdanning.basisklasser.Utdanningsforhold;

import static no.novari.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.novari.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Undervisningsforhold extends Utdanningsforhold  implements FintModelObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
        ARBEIDSFORHOLD("arbeidsforhold", "no.novari.fint.model.administrasjon.personal.Arbeidsforhold", ONE_TO_ONE, "undervisningsforhold"),
        KLASSE("klasse", "no.novari.fint.model.utdanning.elev.Klasse", NONE_TO_MANY, "undervisningsforhold"),
        KONTAKTLARERGRUPPE("kontaktlarergruppe", "no.novari.fint.model.utdanning.elev.Kontaktlarergruppe", NONE_TO_MANY, "undervisningsforhold"),
        UNDERVISNINGSGRUPPE("undervisningsgruppe", "no.novari.fint.model.utdanning.timeplan.Undervisningsgruppe", NONE_TO_MANY, "undervisningsforhold"),
        EKSAMENSGRUPPE("eksamensgruppe", "no.novari.fint.model.utdanning.vurdering.Eksamensgruppe", NONE_TO_MANY, "undervisningsforhold"),
        TIME("time", "no.novari.fint.model.utdanning.timeplan.Time", NONE_TO_MANY, "undervisningsforhold"),
        SKOLE("skole", "no.novari.fint.model.utdanning.utdanningsprogram.Skole", ONE_TO_ONE, "undervisningsforhold"),
        SKOLERESSURS("skoleressurs", "no.novari.fint.model.utdanning.elev.Skoleressurs", ONE_TO_ONE, "undervisningsforhold");
    
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
        identifikators.putAll(super.getIdentifikators());

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
    private final boolean writeable = false;
    @JsonIgnore
    private final List<FintRelation> relations = createRelations();
    private Boolean hovedskole;
}
