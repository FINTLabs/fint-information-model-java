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

import no.fint.model.FintComplexDatatypeObject;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.Link;
import java.util.Date;
import no.fint.model.resource.arkiv.noark.RegistreringResource;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class JournalpostResource extends RegistreringResource implements FintComplexDatatypeObject, FintLinks {
    // Attributes
    private Long antallVedlegg;
    private Date dokumentetsDato;
    private Date forfallsDato;
    private String journalAr;
    private Date journalDato;
    private Long journalPostnummer;
    private Long journalSekvensnummer;
    private Date mottattDato;
    private Date offentlighetsvurdertDato;
    private Date sendtDato;

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getJournalposttype() {
        return getLinks().getOrDefault("journalposttype", Collections.emptyList()); 
    }
    public void addJournalposttype(Link link) {
        addLink("journalposttype", link);
    }
    @JsonIgnore
    public List<Link> getJournalstatus() {
        return getLinks().getOrDefault("journalstatus", Collections.emptyList()); 
    }
    public void addJournalstatus(Link link) {
        addLink("journalstatus", link);
    }
    @JsonIgnore
    public List<Link> getJournalenhet() {
        return getLinks().getOrDefault("journalenhet", Collections.emptyList()); 
    }
    public void addJournalenhet(Link link) {
        addLink("journalenhet", link);
    }
}
