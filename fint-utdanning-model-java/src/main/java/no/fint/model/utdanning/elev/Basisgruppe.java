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
import no.fint.model.utdanning.basisklasser.Gruppe;

import static no.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Basisgruppe extends Gruppe  implements FintModelObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
        SKOLEAR("skolear", "no.fint.model.utdanning.kodeverk.Skolear", NONE_TO_ONE, null),
        ELEVFORHOLD("elevforhold", "no.fint.model.utdanning.elev.Elevforhold", NONE_TO_MANY, "basisgruppe"),
        TERMIN("termin", "no.fint.model.utdanning.kodeverk.Termin", NONE_TO_MANY, null),
        TRINN("trinn", "no.fint.model.utdanning.utdanningsprogram.Arstrinn", ONE_TO_ONE, "basisgruppe"),
        SKOLE("skole", "no.fint.model.utdanning.utdanningsprogram.Skole", ONE_TO_ONE, "basisgruppe"),
        UNDERVISNINGSFORHOLD("undervisningsforhold", "no.fint.model.utdanning.elev.Undervisningsforhold", NONE_TO_MANY, "basisgruppe"),
        GRUPPEMEDLEMSKAP("gruppemedlemskap", "no.fint.model.utdanning.elev.Basisgruppemedlemskap", NONE_TO_MANY, "basisgruppe"),
        KONTAKTLARERGRUPPE("kontaktlarergruppe", "no.fint.model.utdanning.elev.Kontaktlarergruppe", NONE_TO_MANY, "basisgruppe");
    
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
}
