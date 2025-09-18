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
import no.novari.fint.model.felles.kompleksedatatyper.Periode;
import no.novari.fint.model.felles.kompleksedatatyper.Identifikator;

import static no.novari.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.novari.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Fravarsregistrering  implements FintModelObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
        REGISTRERTAV("registrertAv", "no.novari.fint.model.utdanning.elev.Skoleressurs", NONE_TO_ONE),
        FAGGRUPPE("faggruppe", "no.novari.fint.model.utdanning.timeplan.Faggruppe", NONE_TO_ONE),
        UNDERVISNINGSGRUPPE("undervisningsgruppe", "no.novari.fint.model.utdanning.timeplan.Undervisningsgruppe", ONE_TO_ONE),
        FRAVARSTYPE("fravarstype", "no.novari.fint.model.utdanning.kodeverk.Fravarstype", ONE_TO_ONE),
        ELEVFRAVAR("elevfravar", "no.novari.fint.model.utdanning.vurdering.Elevfravar", ONE_TO_ONE);
    
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
    private final boolean writeable = false;
    @JsonIgnore
    private final List<FintRelation> relations = createRelations();
    @NotNull
    private Boolean foresPaVitnemal;
    private String kommentar;
    @NotNull
    private @Valid Periode periode;
    @NotNull
    private @Valid Identifikator systemId;
}
