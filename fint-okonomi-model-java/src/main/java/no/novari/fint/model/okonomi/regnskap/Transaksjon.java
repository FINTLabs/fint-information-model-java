package no.novari.fint.model.okonomi.regnskap;

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
import no.novari.fint.model.okonomi.regnskap.Bilag;
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
public class Transaksjon  implements FintModelObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
        LEVERANDOR("leverandor", "no.novari.fint.model.okonomi.regnskap.Leverandor", NONE_TO_ONE, null),
        ANSVARLIG("ansvarlig", "no.novari.fint.model.administrasjon.personal.Personalressurs", NONE_TO_ONE, null),
        VALUTA("valuta", "no.novari.fint.model.felles.kodeverk.Valuta", ONE_TO_ONE, null),
        POSTERING("postering", "no.novari.fint.model.okonomi.regnskap.Postering", ONE_TO_MANY, "transaksjon");
    
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
        identifikators.put("transaksjonsId", this.transaksjonsId);

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
    @NotNull
    private Long belop;
    private String beskrivelse;
    private List<@Valid Bilag> bilag;
    @NotNull
    private Date forfallsdato;
    private Date oppdateringstidspunkt;
    @NotNull
    private @Valid Identifikator transaksjonsId;
    private Date transaksjonstidspunkt;
}
