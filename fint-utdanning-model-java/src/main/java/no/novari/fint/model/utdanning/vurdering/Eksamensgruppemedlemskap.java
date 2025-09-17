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

import no.novari.fint.model.FintMultiplicity;
import no.novari.fint.model.FintModelObject;
import no.novari.fint.model.FintIdentifikator;
import no.novari.fint.model.FintRelation;
import no.novari.fint.model.utdanning.basisklasser.Gruppemedlemskap;

import static no.novari.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.novari.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Eksamensgruppemedlemskap extends Gruppemedlemskap  implements FintModelObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
        DELEGERTTIL("delegertTil", "no.novari.fint.model.felles.kodeverk.Fylke", NONE_TO_ONE),
        ELEVFORHOLD("elevforhold", "no.novari.fint.model.utdanning.elev.Elevforhold", ONE_TO_ONE),
        FORETRUKKETSKOLE("foretrukketSkole", "no.novari.fint.model.utdanning.utdanningsprogram.Skole", NONE_TO_ONE),
        EKSAMENSGRUPPE("eksamensgruppe", "no.novari.fint.model.utdanning.vurdering.Eksamensgruppe", ONE_TO_ONE),
        NUS("nus", "no.novari.fint.model.utdanning.kodeverk.Karakterstatus", NONE_TO_ONE),
        BETALINGSSTATUS("betalingsstatus", "no.novari.fint.model.utdanning.kodeverk.Betalingsstatus", NONE_TO_ONE),
        FORETRUKKETSENSOR("foretrukketSensor", "no.novari.fint.model.utdanning.vurdering.Sensor", NONE_TO_ONE);
    
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
    private final boolean writeable = false;
    @JsonIgnore
    private final List<FintRelation> relations = createRelations();
    private Boolean delegert;
    private String kandidatnummer;
}
