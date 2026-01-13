package no.novari.fint.model.resource.okonomi.faktura;

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

import no.novari.fint.model.felles.kompleksedatatyper.Identifikator;
import no.novari.fint.model.resource.FintLinks;
import no.novari.fint.model.resource.FintResource;
import no.novari.fint.model.resource.Link;
import no.novari.fint.model.FintIdentifikator;

import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class FakturagrunnlagResource implements FintResource {
    // Attributes
    @JsonIgnore
    @Override
    public List<FintLinks> getNestedResources() {
        List<FintLinks> result = FintResource.super.getNestedResources();
        if (fakturalinjer != null) {
            result.addAll(fakturalinjer);
        }
        if (mottaker != null) {
            result.add(mottaker);
        }
        return result;
    }
    private Long avgiftsbelop;
    @NotEmpty
    private List<@Valid FakturalinjeResource> fakturalinjer;
    private Date leveringsdato;
    @NotNull
    private @Valid FakturamottakerResource mottaker;
    private Long nettobelop;
    @NotNull
    private @Valid Identifikator ordrenummer;
    private Long totalbelop;
    @JsonIgnore
    public Map<String, FintIdentifikator> getIdentifikators() {
        Map<String, FintIdentifikator> identifikators = new HashMap<>();
        identifikators.put("ordrenummer", this.ordrenummer);

        return Collections.unmodifiableMap(identifikators);
    }

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getFaktura() {
        return getLinks().getOrDefault("faktura", Collections.emptyList()); 
    }
    public void addFaktura(Link link) {
        addLink("faktura", link);
    }
    @JsonIgnore
    public List<Link> getFakturautsteder() {
        return getLinks().getOrDefault("fakturautsteder", Collections.emptyList()); 
    }
    public void addFakturautsteder(Link link) {
        addLink("fakturautsteder", link);
    }
}
