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
import no.fint.model.felles.kompleksedatatyper.Identifikator;

import static no.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Skoleressurs  implements FintModelObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
        PERSON("person", "no.fint.model.felles.Person", NONE_TO_ONE),
        PERSONALRESSURS("personalressurs", "no.fint.model.administrasjon.personal.Personalressurs", ONE_TO_ONE),
        UNDERVISNINGSFORHOLD("undervisningsforhold", "no.fint.model.utdanning.elev.Undervisningsforhold", NONE_TO_MANY),
        SKOLE("skole", "no.fint.model.utdanning.utdanningsprogram.Skole", NONE_TO_MANY),
        SENSOR("sensor", "no.fint.model.utdanning.vurdering.Sensor", NONE_TO_MANY);
    
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
        identifikators.put("feidenavn", this.feidenavn);
        identifikators.put("systemId", this.systemId);
    
        return identifikators;
    }

    public boolean isWriteable() {
        return this.writeable;
    }

    @JsonIgnore
    private final boolean writeable = true;
    @JsonIgnore
    private final List<FintRelation> relations = new ArrayList<>(Arrays.asList(Relasjonsnavn.values()));
    private @Valid Identifikator feidenavn;
    @NotNull
    private @Valid Identifikator systemId;
}
