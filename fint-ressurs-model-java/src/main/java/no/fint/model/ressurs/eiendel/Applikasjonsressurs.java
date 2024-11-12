package no.fint.model.ressurs.eiendel;

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
import no.fint.model.felles.kompleksedatatyper.Periode;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

import static no.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Applikasjonsressurs  implements FintModelObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
        BRUKERTYPE("brukertype", "no.fint.model.ressurs.kodeverk.Brukertype", ONE_TO_MANY),
        HANDHEVINGSTYPE("handhevingstype", "no.fint.model.ressurs.kodeverk.Handhevingstype", NONE_TO_ONE),
        LISENSMODELL("lisensmodell", "no.fint.model.ressurs.kodeverk.Lisensmodell", NONE_TO_ONE),
        RESSURSTILGJENGELIGHET("ressurstilgjengelighet", "no.fint.model.ressurs.eiendel.Applikasjonsressurstilgjengelighet", NONE_TO_MANY),
        EIER("eier", "no.fint.model.administrasjon.organisasjon.Organisasjonselement", ONE_TO_ONE),
        APPLIKASJON("applikasjon", "no.fint.model.ressurs.eiendel.Applikasjon", ONE_TO_ONE);
    
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
    @Override
    private Map<String, FintIdentifikator> getIdentifikators() {
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
    private String beskrivelse;
    private Long enhetskostnad;
    @NotNull
    private @Valid Periode gyldighetsperiode;
    private Boolean kreverGodkjenning;
    private Long lisensantall;
    @NotBlank
    private String navn;
    @NotNull
    private @Valid Identifikator systemId;
}
