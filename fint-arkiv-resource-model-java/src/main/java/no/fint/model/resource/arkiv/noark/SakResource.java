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

import no.fint.model.FintMainObject;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.Link;
import no.fint.model.resource.arkiv.noark.SaksmappeResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class SakResource extends SaksmappeResource implements FintMainObject, FintLinks {

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getSaksstatus() {
        return getLinks().getOrDefault("saksstatus", Collections.emptyList()); 
    }
    public void addSaksstatus(Link link) {
        addLink("saksstatus", link);
    }
    @JsonIgnore
    public List<Link> getJournalenhet() {
        return getLinks().getOrDefault("journalenhet", Collections.emptyList()); 
    }
    public void addJournalenhet(Link link) {
        addLink("journalenhet", link);
    }
    @JsonIgnore
    public List<Link> getAdministrativEnhet() {
        return getLinks().getOrDefault("administrativEnhet", Collections.emptyList()); 
    }
    public void addAdministrativEnhet(Link link) {
        addLink("administrativEnhet", link);
    }
    @JsonIgnore
    public List<Link> getSaksansvarlig() {
        return getLinks().getOrDefault("saksansvarlig", Collections.emptyList()); 
    }
    public void addSaksansvarlig(Link link) {
        addLink("saksansvarlig", link);
    }
    @JsonIgnore
    public List<Link> getArkivdel() {
        return getLinks().getOrDefault("arkivdel", Collections.emptyList()); 
    }
    public void addArkivdel(Link link) {
        addLink("arkivdel", link);
    }
    @JsonIgnore
    public List<Link> getAvsluttetAv() {
        return getLinks().getOrDefault("avsluttetAv", Collections.emptyList()); 
    }
    public void addAvsluttetAv(Link link) {
        addLink("avsluttetAv", link);
    }
    @JsonIgnore
    public List<Link> getOpprettetAv() {
        return getLinks().getOrDefault("opprettetAv", Collections.emptyList()); 
    }
    public void addOpprettetAv(Link link) {
        addLink("opprettetAv", link);
    }
}