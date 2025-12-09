package no.fint.model.utdanning.utdanningsprogram;

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
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.felles.basisklasser.Enhet;

import static no.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Skole extends Enhet  implements FintModelObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
        ORGANISASJON("organisasjon", "no.fint.model.administrasjon.organisasjon.Organisasjonselement", NONE_TO_ONE, "skole"),
        FAG("fag", "no.fint.model.utdanning.timeplan.Fag", NONE_TO_MANY, "skole"),
        SKOLEEIERTYPE("skoleeierType", "no.fint.model.utdanning.kodeverk.Skoleeiertype", NONE_TO_ONE, null),
        VIGOREFERANSE("vigoreferanse", "no.fint.model.utdanning.kodeverk.Vigoreferanse", NONE_TO_ONE, null),
        BASISGRUPPE("basisgruppe", "no.fint.model.utdanning.elev.Basisgruppe", NONE_TO_MANY, "skole"),
        ELEVFORHOLD("elevforhold", "no.fint.model.utdanning.elev.Elevforhold", NONE_TO_MANY, "skole"),
        KONTAKTLARERGRUPPE("kontaktlarergruppe", "no.fint.model.utdanning.elev.Kontaktlarergruppe", NONE_TO_MANY, "skole"),
        SKOLERESSURS("skoleressurs", "no.fint.model.utdanning.elev.Skoleressurs", NONE_TO_MANY, "skole"),
        UNDERVISNINGSFORHOLD("undervisningsforhold", "no.fint.model.utdanning.elev.Undervisningsforhold", NONE_TO_MANY, "skole"),
        FAGGRUPPE("faggruppe", "no.fint.model.utdanning.timeplan.Faggruppe", NONE_TO_MANY, "skole"),
        UNDERVISNINGSGRUPPE("undervisningsgruppe", "no.fint.model.utdanning.timeplan.Undervisningsgruppe", NONE_TO_MANY, "skole"),
        EKSAMENSGRUPPE("eksamensgruppe", "no.fint.model.utdanning.vurdering.Eksamensgruppe", NONE_TO_MANY, "skole"),
        UTDANNINGSPROGRAM("utdanningsprogram", "no.fint.model.utdanning.utdanningsprogram.Utdanningsprogram", NONE_TO_MANY, "skole");
    
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
        identifikators.putAll(super.getIdentifikators());
        identifikators.put("skolenummer", this.skolenummer);
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
    private String domenenavn;
    private String juridiskNavn;
    @NotBlank
    private String navn;
    @NotNull
    private @Valid Identifikator skolenummer;
    @NotNull
    private @Valid Identifikator systemId;
}
