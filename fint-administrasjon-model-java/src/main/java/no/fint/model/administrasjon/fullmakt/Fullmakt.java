package no.fint.model.administrasjon.fullmakt;

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
public class Fullmakt  implements FintModelObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
        MYNDIGHET("myndighet", "no.fint.model.administrasjon.kodeverk.Kontodimensjon", NONE_TO_MANY, "fullmakt"),
        RAMME("ramme", "no.fint.model.administrasjon.kodeverk.Ramme", NONE_TO_ONE, null),
        FUNKSJON("funksjon", "no.fint.model.administrasjon.kodeverk.Funksjon", NONE_TO_ONE, null),
        OBJEKT("objekt", "no.fint.model.administrasjon.kodeverk.Objekt", NONE_TO_ONE, null),
        ORGANISASJONSELEMENT("organisasjonselement", "no.fint.model.administrasjon.organisasjon.Organisasjonselement", NONE_TO_ONE, null),
        ART("art", "no.fint.model.administrasjon.kodeverk.Art", NONE_TO_ONE, null),
        ANLEGG("anlegg", "no.fint.model.administrasjon.kodeverk.Anlegg", NONE_TO_ONE, null),
        DIVERSE("diverse", "no.fint.model.administrasjon.kodeverk.Diverse", NONE_TO_ONE, null),
        AKTIVITET("aktivitet", "no.fint.model.administrasjon.kodeverk.Aktivitet", NONE_TO_ONE, null),
        ANSVAR("ansvar", "no.fint.model.administrasjon.kodeverk.Ansvar", NONE_TO_ONE, null),
        STEDFORTREDER("stedfortreder", "no.fint.model.administrasjon.personal.Personalressurs", NONE_TO_ONE, "stedfortreder"),
        KONTRAKT("kontrakt", "no.fint.model.administrasjon.kodeverk.Kontrakt", NONE_TO_ONE, null),
        FULLMEKTIG("fullmektig", "no.fint.model.administrasjon.personal.Personalressurs", NONE_TO_ONE, "fullmakt"),
        PROSJEKT("prosjekt", "no.fint.model.administrasjon.kodeverk.Prosjekt", NONE_TO_ONE, null),
        FORMAL("formal", "no.fint.model.administrasjon.kodeverk.Formal", NONE_TO_ONE, null),
        ROLLE("rolle", "no.fint.model.administrasjon.fullmakt.Rolle", ONE_TO_ONE, "fullmakt"),
        LOPENUMMER("lopenummer", "no.fint.model.administrasjon.kodeverk.Lopenummer", NONE_TO_ONE, null);
    
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
    private @Valid Periode gyldighetsperiode;
    @NotNull
    private @Valid Identifikator systemId;
}
