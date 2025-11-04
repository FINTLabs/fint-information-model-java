package no.fint.model.ressurs.datautstyr;

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

import static no.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class DigitalEnhet  implements FintModelObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
        ADMINISTRATOR("administrator", "no.fint.model.administrasjon.organisasjon.Organisasjonselement", ONE_TO_ONE),
        EIER("eier", "no.fint.model.administrasjon.organisasjon.Organisasjonselement", NONE_TO_ONE),
        PERSONALRESSURS("personalressurs", "no.fint.model.administrasjon.personal.Personalressurs", NONE_TO_ONE),
        ELEV("elev", "no.fint.model.utdanning.elev.Elev", NONE_TO_ONE),
        STATUS("status", "no.fint.model.ressurs.kodeverk.Status", NONE_TO_ONE),
        PRODUSENT("produsent", "no.fint.model.ressurs.kodeverk.Produsent", NONE_TO_ONE),
        ENHETSTYPE("enhetstype", "no.fint.model.ressurs.kodeverk.Enhetstype", ONE_TO_ONE),
        PLATTFORM("plattform", "no.fint.model.ressurs.kodeverk.Plattform", ONE_TO_ONE),
        ENHETSGRUPPEMEDLEMSKAP("enhetsgruppemedlemskap", "no.fint.model.ressurs.datautstyr.Enhetsgruppemedlemskap", NONE_TO_MANY);
    
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
        identifikators.put("dataobjektId", this.dataobjektId);
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
    private @Valid Identifikator dataobjektId;
    private Boolean flerbrukerenhet;
    private String navn;
    private Boolean privateid;
    @NotBlank
    private String serienummer;
    @NotNull
    private @Valid Identifikator systemId;
}
