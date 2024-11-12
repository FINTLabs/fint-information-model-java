package no.fint.model.utdanning.elev;

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
import no.fint.model.utdanning.basisklasser.Utdanningsforhold;

import static no.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Undervisningsforhold extends Utdanningsforhold  implements FintModelObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
        ARBEIDSFORHOLD("arbeidsforhold", "no.fint.model.administrasjon.personal.Arbeidsforhold", ONE_TO_ONE),
        BASISGRUPPE("basisgruppe", "no.fint.model.utdanning.elev.Basisgruppe", NONE_TO_MANY),
        KONTAKTLARERGRUPPE("kontaktlarergruppe", "no.fint.model.utdanning.elev.Kontaktlarergruppe", NONE_TO_MANY),
        UNDERVISNINGSGRUPPE("undervisningsgruppe", "no.fint.model.utdanning.timeplan.Undervisningsgruppe", NONE_TO_MANY),
        EKSAMENSGRUPPE("eksamensgruppe", "no.fint.model.utdanning.vurdering.Eksamensgruppe", NONE_TO_MANY),
        TIME("time", "no.fint.model.utdanning.timeplan.Time", NONE_TO_MANY),
        SKOLE("skole", "no.fint.model.utdanning.utdanningsprogram.Skole", ONE_TO_ONE),
        SKOLERESSURS("skoleressurs", "no.fint.model.utdanning.elev.Skoleressurs", ONE_TO_ONE);
    
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
    @Override
    private Map<String, FintIdentifikator> getIdentifikators() {
        Map<String, FintIdentifikator> identifikators = new HashMap<>();
        identifikators.putAll(super.getIdentifikators());

        return Collections.unmodifiableMap(identifikators);
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

    @JsonIgnore
    private final boolean writeable = false;
    @JsonIgnore
    private final List<FintRelation> relations = createRelations();
    private Boolean hovedskole;
}
