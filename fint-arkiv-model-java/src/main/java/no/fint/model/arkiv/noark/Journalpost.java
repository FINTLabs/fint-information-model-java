package no.fint.model.arkiv.noark;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintComplexDatatypeObject;
import no.fint.model.arkiv.noark.Avskrivning;
import java.util.Date;
import no.fint.model.arkiv.noark.Registrering;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Journalpost extends Registrering implements FintComplexDatatypeObject {
    public enum Relasjonsnavn {
            JOURNALPOSTTYPE,
            JOURNALSTATUS,
            JOURNALENHET
    }

    private Long antallVedlegg;
    private @Valid Avskrivning avskrivning;
    private Date dokumentetsDato;
    private Date forfallsDato;
    private String journalAr;
    private Date journalDato;
    private Long journalPostnummer;
    private Long journalSekvensnummer;
    private Date mottattDato;
    private Date offentlighetsvurdertDato;
    private Date sendtDato;
}
