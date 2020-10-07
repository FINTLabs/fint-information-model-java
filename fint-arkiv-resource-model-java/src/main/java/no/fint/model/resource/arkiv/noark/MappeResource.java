package no.fint.model.resource.arkiv.noark;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.*;

import no.fint.model.FintAbstractObject;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.Link;
import java.util.Date;
import no.fint.model.resource.arkiv.noark.KlasseResource;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.arkiv.noark.MerknadResource;
import no.fint.model.resource.arkiv.noark.PartResource;
import no.fint.model.resource.arkiv.noark.SkjermingResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class MappeResource implements FintAbstractObject, FintLinks {
    // Attributes
    @JsonIgnore
    @Override
    public List<FintLinks> getNestedResources() {
        List<FintLinks> result = FintLinks.super.getNestedResources();
        if (klasse != null) {
            result.add(klasse);
        }
        if (merknad != null) {
            result.addAll(merknad);
        }
        if (part != null) {
            result.addAll(part);
        }
        if (skjerming != null) {
            result.add(skjerming);
        }
        return result;
    }
    private Date avsluttetDato;
    private String beskrivelse;
    private @Valid KlasseResource klasse;
    private @Valid Identifikator mappeId;
    private List<@Valid MerknadResource> merknad;
    private List<String> noekkelord;
    private String offentligTittel;
    private Date opprettetDato;
    private List<@Valid PartResource> part;
    private @Valid SkjermingResource skjerming;
    private @Valid Identifikator systemId;
    private String tittel;

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
}