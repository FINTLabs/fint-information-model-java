package no.fint.model.arkiv.noark;

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
import no.fint.model.arkiv.noark.Klasse;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

import static no.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Klassifikasjonssystem  implements FintModelObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
        KLASSIFIKASJONSTYPE("klassifikasjonstype", "no.fint.model.arkiv.kodeverk.Klassifikasjonstype", NONE_TO_ONE),
        ARKIVDEL("arkivdel", "no.fint.model.arkiv.noark.Arkivdel", ONE_TO_MANY);
    
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
        identifikators.put("systemId", this.systemId);
    
        return identifikators;
    }
    @JsonIgnore
    private final List<FintRelation> relations = new ArrayList<>(Arrays.asList(Relasjonsnavn.values()));
    private String avsluttetAv;
    private @Valid Date avsluttetDato;
    private String beskrivelse;
    @NotEmpty
    private List<@Valid Klasse> klasse;
    @NotBlank
    private String opprettetAv;
    @NotNull
    private @Valid Date opprettetDato;
    @NotNull
    private @Valid Identifikator systemId;
    @NotBlank
    private String tittel;
}
