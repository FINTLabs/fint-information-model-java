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
import java.util.HashMap;
import javax.validation.Valid;
import javax.validation.constraints.*;

import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.FintLinks;
import no.fint.model.FintComplexDatatypeObject;
import no.fint.model.resource.Link;
import no.fint.model.FintIdentifikator;
import no.fint.model.resource.arkiv.noark.DokumentobjektResource;
import java.util.Date;
import no.fint.model.resource.arkiv.noark.PartResource;
import no.fint.model.resource.arkiv.noark.SkjermingResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class DokumentbeskrivelseResource implements FintComplexDatatypeObject, FintLinks {
    // Attributes
    @JsonIgnore
    @Override
    public List<FintLinks> getNestedResources() {
        List<FintLinks> result = FintLinks.super.getNestedResources();
        if (dokumentobjekt != null) {
            result.addAll(dokumentobjekt);
        }
        if (part != null) {
            result.addAll(part);
        }
        if (skjerming != null) {
            result.add(skjerming);
        }
        return result;
    }
    private String beskrivelse;
    private Long dokumentnummer;
    private List<@Valid DokumentobjektResource> dokumentobjekt;
    private List<String> forfatter;
    private @Valid Date opprettetDato;
    private List<@Valid PartResource> part;
    private List<String> referanseArkivdel;
    private @Valid SkjermingResource skjerming;
    private @Valid Date tilknyttetDato;
    @NotBlank
    private String tittel;

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getDokumentstatus() {
        return getLinks().getOrDefault("dokumentstatus", Collections.emptyList()); 
    }
    public void addDokumentstatus(Link link) {
        addLink("dokumentstatus", link);
    }
    @JsonIgnore
    public List<Link> getDokumentType() {
        return getLinks().getOrDefault("dokumentType", Collections.emptyList()); 
    }
    public void addDokumentType(Link link) {
        addLink("dokumentType", link);
    }
    @JsonIgnore
    public List<Link> getTilknyttetRegistreringSom() {
        return getLinks().getOrDefault("tilknyttetRegistreringSom", Collections.emptyList()); 
    }
    public void addTilknyttetRegistreringSom(Link link) {
        addLink("tilknyttetRegistreringSom", link);
    }
    @JsonIgnore
    public List<Link> getTilknyttetAv() {
        return getLinks().getOrDefault("tilknyttetAv", Collections.emptyList()); 
    }
    public void addTilknyttetAv(Link link) {
        addLink("tilknyttetAv", link);
    }
    @JsonIgnore
    public List<Link> getOpprettetAv() {
        return getLinks().getOrDefault("opprettetAv", Collections.emptyList()); 
    }
    public void addOpprettetAv(Link link) {
        addLink("opprettetAv", link);
    }
}
