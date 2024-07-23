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
import no.fint.model.FintAbstractObject;
import no.fint.model.FintIdentifikator;
import no.fint.model.FintRelation;
import no.fint.model.arkiv.noark.Registrering;
import no.fint.model.arkiv.noark.Journalpost;
import java.util.Date;
import no.fint.model.arkiv.noark.Mappe;

import static no.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public abstract class Saksmappe extends Mappe  implements FintAbstractObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
        SAKSMAPPETYPE("saksmappetype", "no.fint.model.arkiv.kodeverk.Saksmappetype", NONE_TO_ONE),
        SAKSSTATUS("saksstatus", "no.fint.model.arkiv.kodeverk.Saksstatus", ONE_TO_ONE),
        JOURNALENHET("journalenhet", "no.fint.model.arkiv.noark.AdministrativEnhet", NONE_TO_ONE),
        ADMINISTRATIVENHET("administrativEnhet", "no.fint.model.arkiv.noark.AdministrativEnhet", ONE_TO_ONE),
        SAKSANSVARLIG("saksansvarlig", "no.fint.model.arkiv.noark.Arkivressurs", ONE_TO_ONE);
    
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
    
        return identifikators;
    }

    public boolean isWriteable() {
        return this.writeable;
    }

    private final boolean writeable = true;
    @JsonIgnore
    private final List<FintRelation> relations = new ArrayList<>(Arrays.asList(Relasjonsnavn.values()));
    private List<@Valid Registrering> arkivnotat;
    private List<@Valid Journalpost> journalpost;
    private String saksaar;
    private @Valid Date saksdato;
    private String sakssekvensnummer;
    private @Valid Date utlaantDato;
}
