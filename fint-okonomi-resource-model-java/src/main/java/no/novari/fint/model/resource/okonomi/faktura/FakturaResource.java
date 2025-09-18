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
import no.novari.fint.model.resource.felles.kompleksedatatyper.AdresseResource;
import java.util.Date;
import no.novari.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class FakturaResource implements FintResource {
    // Attributes
    @JsonIgnore
    @Override
    public List<FintLinks> getNestedResources() {
        List<FintLinks> result = FintResource.super.getNestedResources();
        if (adresse != null) {
            result.add(adresse);
        }
        return result;
    }
    private @Valid AdresseResource adresse;
    @NotNull
    private Long belop;
    private Boolean betalt;
    @NotNull
    private Date dato;
    @NotNull
    private @Valid Identifikator fakturanummer;
    private Boolean fakturert;
    @NotNull
    private Date forfallsdato;
    private Boolean kreditert;
    @NotBlank
    private String mottaker;
    private Long restbelop;
    @JsonIgnore
    public Map<String, FintIdentifikator> getIdentifikators() {
        Map<String, FintIdentifikator> identifikators = new HashMap<>();
        identifikators.put("fakturanummer", this.fakturanummer);

        return Collections.unmodifiableMap(identifikators);
    }

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
        
    @JsonIgnore
    public List<Link> getFakturagrunnlag() {
        return getLinks().getOrDefault("fakturagrunnlag", Collections.emptyList()); 
    }
    public void addFakturagrunnlag(Link link) {
        addLink("fakturagrunnlag", link);
    }
}
