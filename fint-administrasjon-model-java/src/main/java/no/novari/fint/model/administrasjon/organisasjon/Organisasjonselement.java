package no.novari.fint.model.administrasjon.organisasjon;

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
import no.novari.fint.model.felles.basisklasser.Enhet;

import static no.novari.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.novari.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Organisasjonselement extends Enhet  implements FintModelObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
        ORGANISASJONSTYPE("organisasjonstype", "no.novari.fint.model.administrasjon.kodeverk.Organisasjonstype", NONE_TO_ONE),
        ANSVAR("ansvar", "no.novari.fint.model.administrasjon.kodeverk.Ansvar", NONE_TO_MANY),
        LEDER("leder", "no.novari.fint.model.administrasjon.personal.Personalressurs", NONE_TO_ONE),
        OVERORDNET("overordnet", "no.novari.fint.model.administrasjon.organisasjon.Organisasjonselement", ONE_TO_ONE),
        UNDERORDNET("underordnet", "no.novari.fint.model.administrasjon.organisasjon.Organisasjonselement", NONE_TO_MANY),
        SKOLE("skole", "no.novari.fint.model.utdanning.utdanningsprogram.Skole", NONE_TO_ONE),
        ARBEIDSFORHOLD("arbeidsforhold", "no.novari.fint.model.administrasjon.personal.Arbeidsforhold", NONE_TO_MANY);
    
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
        identifikators.put("organisasjonsId", this.organisasjonsId);
        identifikators.put("organisasjonsKode", this.organisasjonsKode);

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
    private @Valid Periode gyldighetsperiode;
    private String kortnavn;
    private String navn;
    @NotNull
    private @Valid Identifikator organisasjonsId;
    @NotNull
    private @Valid Identifikator organisasjonsKode;
}
