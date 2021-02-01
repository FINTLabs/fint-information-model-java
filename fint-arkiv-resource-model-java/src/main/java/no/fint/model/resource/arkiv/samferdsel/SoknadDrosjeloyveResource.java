package no.fint.model.resource.arkiv.samferdsel;

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
public class SoknadDrosjeloyveResource extends SaksmappeResource implements FintMainObject, FintLinks {
    // Attributes
    @NotBlank
    private String organisasjonsnavn;
    @NotBlank
    private String organisasjonsnummer;

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
}
