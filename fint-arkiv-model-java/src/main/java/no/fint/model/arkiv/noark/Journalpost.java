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
    private @Valid Date dokumentetsDato;
    private @Valid Date forfallsDato;
    private String journalAr;
    private @Valid Date journalDato;
    private Long journalPostnummer;
    private Long journalSekvensnummer;
    private @Valid Date mottattDato;
    private @Valid Date offentlighetsvurdertDato;
    private @Valid Date sendtDato;
}
