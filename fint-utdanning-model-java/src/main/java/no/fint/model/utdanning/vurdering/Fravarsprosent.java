package no.fint.model.utdanning.vurdering;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintComplexDatatypeObject;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Fravarsprosent implements FintComplexDatatypeObject {
    @NotNull
    private Integer fravarstimer;
    @NotNull
    private Integer prosent;
    @NotNull
    private Integer undervisningstimer;
}
