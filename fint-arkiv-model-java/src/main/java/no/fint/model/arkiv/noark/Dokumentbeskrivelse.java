// Built from tag v3.6.0-rc-1

package no.fint.model.arkiv.noark;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintComplexDatatypeObject;
import no.fint.model.arkiv.noark.Dokumentobjekt;
import java.util.Date;
import no.fint.model.arkiv.noark.Part;
import no.fint.model.arkiv.noark.Skjerming;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Dokumentbeskrivelse implements FintComplexDatatypeObject {
    public enum Relasjonsnavn {
            DOKUMENTSTATUS,
            DOKUMENTTYPE,
            TILKNYTTETREGISTRERINGSOM,
            TILKNYTTETAV,
            OPPRETTETAV
    }

    private String beskrivelse;
    private Long dokumentnummer;
    private List<@Valid Dokumentobjekt> dokumentobjekt;
    private List<String> forfatter;
    private Date opprettetDato;
    private List<@Valid Part> part;
    private List<String> referanseArkivdel;
    private @Valid Skjerming skjerming;
    private Date tilknyttetDato;
    @NotBlank
    private String tittel;
}
