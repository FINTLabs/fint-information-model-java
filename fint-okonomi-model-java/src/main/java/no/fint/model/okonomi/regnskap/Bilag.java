package no.fint.model.okonomi.regnskap;

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
import no.fint.model.FintMultiplicity;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.FintComplexDatatypeObject;
import no.fint.model.FintIdentifikator;
import no.fint.model.FintRelation;
import java.util.Date;

import static no.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Bilag  implements FintComplexDatatypeObject {

    public boolean isWriteable() {
        return this.writeable;
    }

    @JsonIgnore
    private final boolean writeable = true;
    @NotNull
    private Date bilagsdato;
    private String bilagsnummer;
    private String data;
    private String filnavn;
    private String referanse;
    private String url;
}
