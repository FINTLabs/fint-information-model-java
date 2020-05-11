// Built from tag v3.5.0

package no.fint.model.resource.utdanning.basisklasser;

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
import no.fint.model.felles.kompleksedatatyper.Periode;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class GruppeResource implements FintAbstractObject, FintLinks {
    // Attributes
    @NotBlank
    private String beskrivelse;
    @NotBlank
    private String navn;
    private List<@Valid Periode> periode;
    @NotNull
    private @Valid Identifikator systemId;

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
}
