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
        ORGANISASJON("organisasjon", "no.fint.model.administrasjon.organisasjon.Organisasjonselement", NONE_TO_ONE),
        FAG("fag", "no.fint.model.utdanning.timeplan.Fag", NONE_TO_MANY),
        SKOLEEIERTYPE("skoleeierType", "no.fint.model.utdanning.kodeverk.Skoleeiertype", NONE_TO_ONE),
        VIGOREFERANSE("vigoreferanse", "no.fint.model.utdanning.kodeverk.Vigoreferanse", NONE_TO_ONE),
        ELEVFORHOLD("elevforhold", "no.fint.model.utdanning.elev.Elevforhold", NONE_TO_MANY),
        KLASSE("klasse", "no.fint.model.utdanning.elev.Klasse", NONE_TO_MANY),
        KONTAKTLARERGRUPPE("kontaktlarergruppe", "no.fint.model.utdanning.elev.Kontaktlarergruppe", NONE_TO_MANY),
        SKOLERESSURS("skoleressurs", "no.fint.model.utdanning.elev.Skoleressurs", NONE_TO_MANY),
        UNDERVISNINGSFORHOLD("undervisningsforhold", "no.fint.model.utdanning.elev.Undervisningsforhold", NONE_TO_MANY),
        FAGGRUPPE("faggruppe", "no.fint.model.utdanning.timeplan.Faggruppe", NONE_TO_MANY),
        UNDERVISNINGSGRUPPE("undervisningsgruppe", "no.fint.model.utdanning.timeplan.Undervisningsgruppe", NONE_TO_MANY),
        EKSAMENSGRUPPE("eksamensgruppe", "no.fint.model.utdanning.vurdering.Eksamensgruppe", NONE_TO_MANY),
        UTDANNINGSPROGRAM("utdanningsprogram", "no.fint.model.utdanning.utdanningsprogram.Utdanningsprogram", NONE_TO_MANY);
    
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
