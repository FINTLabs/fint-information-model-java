package no.fint.model.okonomi.regnskap;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintComplexDatatypeObject;
import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Bilag implements FintComplexDatatypeObject {
    @NotNull
    private Date bilagsdato;
    private String bilagsnummer;
    private String data;
    private String filnavn;
    private String referanse;
    private String url;
}
