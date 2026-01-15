package no.novari.fint.model.administrasjon.personal;

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
import no.novari.fint.model.felles.kompleksedatatyper.Periode;

import static no.novari.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.novari.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Fravar  implements FintModelObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
        FRAVARSGRUNN("fravarsgrunn", "no.novari.fint.model.administrasjon.kodeverk.Fravarsgrunn", NONE_TO_ONE, null),
        FRAVARSTYPE("fravarstype", "no.novari.fint.model.administrasjon.kodeverk.Fravarstype", ONE_TO_ONE, null),
        ARBEIDSFORHOLD("arbeidsforhold", "no.novari.fint.model.administrasjon.personal.Arbeidsforhold", ONE_TO_MANY, "fravar"),
        FORTSETTELSE("fortsettelse", "no.novari.fint.model.administrasjon.personal.Fravar", NONE_TO_ONE, "fortsetter"),
        GODKJENNER("godkjenner", "no.novari.fint.model.administrasjon.personal.Personalressurs", NONE_TO_ONE, null),
        FORTSETTER("fortsetter", "no.novari.fint.model.administrasjon.personal.Fravar", NONE_TO_ONE, "fortsettelse");
    
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
        identifikators.put("kildesystemId", this.kildesystemId);
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
    private final boolean writeable = true;
    @JsonIgnore
    private final List<FintRelation> relations = createRelations();
    private @Valid Date godkjent;
    private @Valid Identifikator kildesystemId;
    @NotNull
    private @Valid Periode periode;
    @NotNull
    private Long prosent;
    private @Valid Identifikator systemId;
}
