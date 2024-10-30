package no.fint.model.administrasjon.personal;

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
import java.util.Date;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.felles.kompleksedatatyper.Periode;

import static no.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Fravar  implements FintModelObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
        FRAVARSGRUNN("fravarsgrunn", "no.fint.model.administrasjon.kodeverk.Fravarsgrunn", NONE_TO_ONE),
        FRAVARSTYPE("fravarstype", "no.fint.model.administrasjon.kodeverk.Fravarstype", ONE_TO_ONE),
        ARBEIDSFORHOLD("arbeidsforhold", "no.fint.model.administrasjon.personal.Arbeidsforhold", ONE_TO_MANY),
        FORTSETTELSE("fortsettelse", "no.fint.model.administrasjon.personal.Fravar", NONE_TO_ONE),
        GODKJENNER("godkjenner", "no.fint.model.administrasjon.personal.Personalressurs", NONE_TO_ONE),
        FORTSETTER("fortsetter", "no.fint.model.administrasjon.personal.Fravar", NONE_TO_ONE);
    
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
        identifikators.put("kildesystemId", this.kildesystemId);
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
    private @Valid Date godkjent;
    private @Valid Identifikator kildesystemId;
    @NotNull
    private @Valid Periode periode;
    @NotNull
    private Long prosent;
    private @Valid Identifikator systemId;
}
