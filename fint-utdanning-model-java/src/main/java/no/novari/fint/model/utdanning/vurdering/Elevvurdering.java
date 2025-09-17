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
import no.fint.model.FintMultiplicity;
import no.novari.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.FintModelObject;
import no.fint.model.FintIdentifikator;
import no.fint.model.FintRelation;

import static no.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Elevvurdering  implements FintModelObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
        ELEVFORHOLD("elevforhold", "no.fint.model.utdanning.elev.Elevforhold", ONE_TO_ONE),
        SLUTTFAGVURDERING("sluttfagvurdering", "no.fint.model.utdanning.vurdering.Sluttfagvurdering", NONE_TO_MANY),
        UNDERVEISORDENSVURDERING("underveisordensvurdering", "no.fint.model.utdanning.vurdering.Underveisordensvurdering", NONE_TO_MANY),
        VITNEMALSMERKNAD("vitnemalsmerknad", "no.fint.model.utdanning.kodeverk.Vitnemalsmerknad", NONE_TO_MANY),
        UNDERVEISFAGVURDERING("underveisfagvurdering", "no.fint.model.utdanning.vurdering.Underveisfagvurdering", NONE_TO_MANY),
        HALVARSORDENSVURDERING("halvarsordensvurdering", "no.fint.model.utdanning.vurdering.Halvarsordensvurdering", NONE_TO_MANY),
        HALVARSFAGVURDERING("halvarsfagvurdering", "no.fint.model.utdanning.vurdering.Halvarsfagvurdering", NONE_TO_MANY),
        SLUTTORDENSVURDERING("sluttordensvurdering", "no.fint.model.utdanning.vurdering.Sluttordensvurdering", NONE_TO_MANY),
        EKSAMENSVURDERING("eksamensvurdering", "no.fint.model.utdanning.vurdering.Eksamensvurdering", NONE_TO_MANY);
    
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
    private @Valid Identifikator systemId;
}
