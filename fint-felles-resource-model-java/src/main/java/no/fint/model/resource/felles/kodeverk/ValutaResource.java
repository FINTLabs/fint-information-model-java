package no.fint.model.resource.felles.kodeverk;

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
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ValutaResource implements FintMainObject, FintLinks {
    // Attributes
    @NotNull
    private @Valid Identifikator bokstavkode;
    @NotBlank
    private String navn;
    @NotNull
    private @Valid Identifikator nummerkode;

    // Relations
    @Getter
    private final Map<String, List<Link>> links = createLinks();
}
