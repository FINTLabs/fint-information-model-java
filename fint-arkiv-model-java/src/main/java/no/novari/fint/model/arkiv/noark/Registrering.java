package no.novari.fint.model.arkiv.noark;

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
import no.novari.fint.model.FintAbstractObject;
import no.novari.fint.model.FintIdentifikator;
import no.novari.fint.model.FintRelation;
import java.util.Date;
import no.novari.fint.model.arkiv.noark.Dokumentbeskrivelse;
import no.novari.fint.model.arkiv.noark.Klasse;
import no.novari.fint.model.arkiv.noark.Korrespondansepart;
import no.novari.fint.model.arkiv.noark.Merknad;
import no.novari.fint.model.arkiv.noark.Part;
import no.novari.fint.model.arkiv.noark.Skjerming;

import static no.novari.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.novari.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.novari.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class Registrering  implements FintAbstractObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
        TILGANGSGRUPPE("tilgangsgruppe", "no.novari.fint.model.arkiv.kodeverk.Tilgangsgruppe", NONE_TO_ONE),
        ADMINISTRATIVENHET("administrativEnhet", "no.novari.fint.model.arkiv.noark.AdministrativEnhet", NONE_TO_ONE),
        SAKSBEHANDLER("saksbehandler", "no.novari.fint.model.arkiv.noark.Arkivressurs", NONE_TO_ONE),
        ARKIVERTAV("arkivertAv", "no.novari.fint.model.arkiv.noark.Arkivressurs", ONE_TO_ONE),
        OPPRETTETAV("opprettetAv", "no.novari.fint.model.arkiv.noark.Arkivressurs", ONE_TO_ONE);
    
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
    private @Valid Date arkivertDato;
    private String beskrivelse;
    private List<@Valid Dokumentbeskrivelse> dokumentbeskrivelse;
    private List<String> forfatter;
    private @Valid Klasse klasse;
    private List<@Valid Korrespondansepart> korrespondansepart;
    private List<@Valid Merknad> merknad;
    private List<String> nokkelord;
    private String offentligTittel;
    private @Valid Date opprettetDato;
    private List<@Valid Part> part;
    private List<String> referanseArkivDel;
    private String registreringsId;
    private @Valid Skjerming skjerming;
    @NotBlank
    private String tittel;
}
