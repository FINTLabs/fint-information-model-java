package no.novari.fint.model.utdanning.vurdering;

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
import java.util.Date;
import no.novari.fint.model.utdanning.basisklasser.Gruppe;

import static no.novari.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.novari.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Eksamensgruppe extends Gruppe  implements FintModelObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
        EKSAMEN("eksamen", "no.novari.fint.model.utdanning.timeplan.Eksamen", NONE_TO_ONE),
        FAG("fag", "no.novari.fint.model.utdanning.timeplan.Fag", ONE_TO_ONE),
        SKOLE("skole", "no.novari.fint.model.utdanning.utdanningsprogram.Skole", ONE_TO_ONE),
        TERMIN("termin", "no.novari.fint.model.utdanning.kodeverk.Termin", ONE_TO_ONE),
        EKSAMENSFORM("eksamensform", "no.novari.fint.model.utdanning.kodeverk.Eksamensform", NONE_TO_ONE),
        SKOLEAR("skolear", "no.novari.fint.model.utdanning.kodeverk.Skolear", NONE_TO_ONE),
        UNDERVISNINGSFORHOLD("undervisningsforhold", "no.novari.fint.model.utdanning.elev.Undervisningsforhold", NONE_TO_MANY),
        GRUPPEMEDLEMSKAP("gruppemedlemskap", "no.novari.fint.model.utdanning.vurdering.Eksamensgruppemedlemskap", NONE_TO_MANY),
        SENSOR("sensor", "no.novari.fint.model.utdanning.vurdering.Sensor", NONE_TO_MANY);
    
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
    private @Valid Date eksamensdato;
}
