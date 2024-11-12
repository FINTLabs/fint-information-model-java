package no.fint.model.utdanning.vurdering;

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
import no.fint.model.utdanning.basisklasser.Gruppemedlemskap;

import static no.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Eksamensgruppemedlemskap extends Gruppemedlemskap  implements FintModelObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
        DELEGERTTIL("delegertTil", "no.fint.model.felles.kodeverk.Fylke", NONE_TO_ONE),
        ELEVFORHOLD("elevforhold", "no.fint.model.utdanning.elev.Elevforhold", ONE_TO_ONE),
        FORETRUKKETSKOLE("foretrukketSkole", "no.fint.model.utdanning.utdanningsprogram.Skole", NONE_TO_ONE),
        EKSAMENSGRUPPE("eksamensgruppe", "no.fint.model.utdanning.vurdering.Eksamensgruppe", ONE_TO_ONE),
        NUS("nus", "no.fint.model.utdanning.kodeverk.Karakterstatus", NONE_TO_ONE),
        BETALINGSSTATUS("betalingsstatus", "no.fint.model.utdanning.kodeverk.Betalingsstatus", NONE_TO_ONE),
        FORETRUKKETSENSOR("foretrukketSensor", "no.fint.model.utdanning.vurdering.Sensor", NONE_TO_ONE);
    
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
    private Boolean delegert;
    private String kandidatnummer;
}
