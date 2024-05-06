package no.fint.model.utdanning.elev;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
import java.util.Arrays;
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
        SKOLEAR("skolear", "no.fint.model.utdanning.kodeverk.Skolear", NONE_TO_ONE),
        ELEVFORHOLD("elevforhold", "no.fint.model.utdanning.elev.Elevforhold", NONE_TO_MANY),
        TERMIN("termin", "no.fint.model.utdanning.kodeverk.Termin", NONE_TO_MANY),
        TRINN("trinn", "no.fint.model.utdanning.utdanningsprogram.Arstrinn", ONE_TO_ONE),
        SKOLE("skole", "no.fint.model.utdanning.utdanningsprogram.Skole", ONE_TO_ONE),
        UNDERVISNINGSFORHOLD("undervisningsforhold", "no.fint.model.utdanning.elev.Undervisningsforhold", NONE_TO_MANY),
        GRUPPEMEDLEMSKAP("gruppemedlemskap", "no.fint.model.utdanning.elev.Basisgruppemedlemskap", NONE_TO_MANY),
        KONTAKTLARERGRUPPE("kontaktlarergruppe", "no.fint.model.utdanning.elev.Kontaktlarergruppe", NONE_TO_MANY);
    
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
        identifikators.putAll(super.getIdentifikators());
    
        return identifikators;
    }
    @JsonIgnore
    private final List<FintRelation> relations = new ArrayList<>(Arrays.asList(Relasjonsnavn.values()));
}
