package no.fint.model.arkiv.noark;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintAbstractObject;
import no.fint.model.arkiv.noark.Registrering;
import no.fint.model.arkiv.noark.Journalpost;
import java.util.Date;
import no.fint.model.arkiv.noark.Mappe;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public abstract class Saksmappe extends Mappe implements FintAbstractObject {
    public enum Relasjonsnavn {
            SAKSSTATUS,
            JOURNALENHET,
            ADMINISTRATIVENHET,
            SAKSANSVARLIG
    }

    private List<@Valid Registrering> arkivnotat;
    private List<@Valid Journalpost> journalpost;
    private String saksaar;
    private @Valid Date saksdato;
    private String sakssekvensnummer;
    private @Valid Date utlaantDato;
}
