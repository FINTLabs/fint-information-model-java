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
import no.novari.fint.model.FintModelObject;
import no.novari.fint.model.FintIdentifikator;
import no.novari.fint.model.FintRelation;
import java.util.Date;
import no.novari.fint.model.felles.kompleksedatatyper.Identifikator;

import static no.novari.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.novari.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Karakterhistorie  implements FintModelObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
        OPPDATERTAV("oppdatertAv", "no.novari.fint.model.utdanning.elev.Skoleressurs", NONE_TO_ONE, null),
        OPPRINNELIGKARAKTERVERDI("opprinneligKarakterverdi", "no.novari.fint.model.utdanning.vurdering.Karakterverdi", NONE_TO_ONE, null),
        OPPRINNELIGKARAKTERSTATUS("opprinneligKarakterstatus", "no.novari.fint.model.utdanning.kodeverk.Karakterstatus", NONE_TO_ONE, null),
        KARAKTERVERDI("karakterverdi", "no.novari.fint.model.utdanning.vurdering.Karakterverdi", NONE_TO_ONE, null),
        KARAKTERSTATUS("karakterstatus", "no.novari.fint.model.utdanning.kodeverk.Karakterstatus", NONE_TO_ONE, null);
    
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
    private @Valid Date endretDato;
    @NotNull
    private @Valid Identifikator systemId;
}
