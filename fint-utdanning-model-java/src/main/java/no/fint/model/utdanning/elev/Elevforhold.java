package no.fint.model.utdanning.elev;

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
import no.fint.model.utdanning.vurdering.Anmerkninger;
import java.util.Date;
import no.fint.model.felles.kompleksedatatyper.Periode;
import no.fint.model.utdanning.basisklasser.Utdanningsforhold;

import static no.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Elevforhold extends Utdanningsforhold  implements FintModelObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
        ELEV("elev", "no.fint.model.utdanning.elev.Elev", ONE_TO_ONE),
        SIDEMAL("sidemal", "no.fint.model.utdanning.kodeverk.Fagmerknad", NONE_TO_MANY),
        KATEGORI("kategori", "no.fint.model.utdanning.kodeverk.Elevkategori", NONE_TO_ONE),
        KROPPSOVING("kroppsoving", "no.fint.model.utdanning.kodeverk.Fagmerknad", NONE_TO_ONE),
        SKOLE("skole", "no.fint.model.utdanning.utdanningsprogram.Skole", ONE_TO_ONE),
        AVBRUDDSARSAK("avbruddsarsak", "no.fint.model.utdanning.kodeverk.Avbruddsarsak", NONE_TO_MANY),
        FRAVARSREGISTRERINGER("fravarsregistreringer", "no.fint.model.utdanning.vurdering.Elevfravar", NONE_TO_ONE),
        FAGGRUPPEMEDLEMSKAP("faggruppemedlemskap", "no.fint.model.utdanning.timeplan.Faggruppemedlemskap", NONE_TO_MANY),
        SKOLEAR("skolear", "no.fint.model.utdanning.kodeverk.Skolear", NONE_TO_ONE),
        BASISGRUPPE("basisgruppe", "no.fint.model.utdanning.elev.Basisgruppe", NONE_TO_MANY),
        BASISGRUPPEMEDLEMSKAP("basisgruppemedlemskap", "no.fint.model.utdanning.elev.Basisgruppemedlemskap", NONE_TO_MANY),
        UNDERVISNINGSGRUPPEMEDLEMSKAP("undervisningsgruppemedlemskap", "no.fint.model.utdanning.timeplan.Undervisningsgruppemedlemskap", NONE_TO_MANY),
        VURDERING("vurdering", "no.fint.model.utdanning.vurdering.Vurdering", NONE_TO_MANY),
        SLUTTORDENSVURDERING("sluttordensvurdering", "no.fint.model.utdanning.vurdering.Sluttordensvurdering", NONE_TO_MANY),
        KONTAKTLARERGRUPPE("kontaktlarergruppe", "no.fint.model.utdanning.elev.Kontaktlarergruppe", NONE_TO_MANY),
        UNDERVEISFAGVURDERING("underveisfagvurdering", "no.fint.model.utdanning.vurdering.Underveisfagvurdering", NONE_TO_MANY),
        HALVARSFAGVURDERING("halvarsfagvurdering", "no.fint.model.utdanning.vurdering.Halvarsfagvurdering", NONE_TO_MANY),
        SLUTTFAGVURDERING("sluttfagvurdering", "no.fint.model.utdanning.vurdering.Sluttfagvurdering", NONE_TO_MANY),
        PERSONGRUPPEMEDLEMSKAP("persongruppemedlemskap", "no.fint.model.utdanning.elev.Persongruppemedlemskap", NONE_TO_MANY),
        EKSAMENSGRUPPEMEDLEMSKAP("eksamensgruppemedlemskap", "no.fint.model.utdanning.vurdering.Eksamensgruppemedlemskap", NONE_TO_MANY),
        KONTAKTLARERGRUPPEMEDLEMSKAP("kontaktlarergruppemedlemskap", "no.fint.model.utdanning.elev.Kontaktlarergruppemedlemskap", NONE_TO_MANY),
        ELEVFRAVAR("elevfravar", "no.fint.model.utdanning.vurdering.Fravarsoversikt", NONE_TO_MANY),
        TILRETTELEGGING("tilrettelegging", "no.fint.model.utdanning.elev.Elevtilrettelegging", NONE_TO_MANY),
        HALVARSORDENSVURDERING("halvarsordensvurdering", "no.fint.model.utdanning.vurdering.Halvarsordensvurdering", NONE_TO_MANY),
        PROGRAMOMRADE("programomrade", "no.fint.model.utdanning.utdanningsprogram.Programomrade", NONE_TO_ONE),
        ELEVVURDERING("elevvurdering", "no.fint.model.utdanning.vurdering.Elevvurdering", NONE_TO_ONE),
        FRAVAR("fravar", "no.fint.model.utdanning.vurdering.Fravar", NONE_TO_MANY),
        PROGRAMOMRADEMEDLEMSKAP("programomrademedlemskap", "no.fint.model.utdanning.utdanningsprogram.Programomrademedlemskap", NONE_TO_MANY),
        UNDERVEISORDENSVURDERING("underveisordensvurdering", "no.fint.model.utdanning.vurdering.Underveisordensvurdering", NONE_TO_MANY),
        EKSAMENSGRUPPE("eksamensgruppe", "no.fint.model.utdanning.vurdering.Eksamensgruppe", NONE_TO_MANY),
        UNDERVISNINGSGRUPPE("undervisningsgruppe", "no.fint.model.utdanning.timeplan.Undervisningsgruppe", NONE_TO_MANY);
    
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
    private Map<String, FintIdentifikator> createIdentifikators() {
        Map<String, FintIdentifikator> identifikators = new HashMap<>();
        identifikators.putAll(super.getIdentifikators());

        return Collections.unmodifiableMap(identifikators);
    }
    @JsonIgnore
    private List<FintRelation> createRelations() {
        List<FintRelation> relations = new ArrayList<>();
        relations.addAll(super.getRelations());

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
    @JsonIgnore
    private final Map<String, FintIdentifikator> identifikators = createIdentifikators();
    private List<@Valid Anmerkninger> anmerkninger;
    private Date avbruddsdato;
    private @Valid Periode gyldighetsperiode;
    private Boolean hovedskole;
    private Boolean tosprakligFagopplaring;
}
