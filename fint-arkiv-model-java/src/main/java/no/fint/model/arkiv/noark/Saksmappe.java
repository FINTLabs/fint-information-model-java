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
            SAKSMAPPETYPE("no.fint.model.arkiv.noark.Saksmappetype", "0..1"),
            SAKSSTATUS("no.fint.model.arkiv.noark.Saksstatus", "1"),
            JOURNALENHET("no.fint.model.arkiv.noark.AdministrativEnhet", "0..1"),
            ADMINISTRATIVENHET("no.fint.model.arkiv.noark.AdministrativEnhet", "1"),
            SAKSANSVARLIG("no.fint.model.arkiv.noark.Arkivressurs", "1");
	
		private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }

        public String getTypeName() {
            return typeName;
        }

        public String getMultiplicity() {
            return multiplicity;
        }
    }

    private List<@Valid Registrering> arkivnotat;
    private List<@Valid Journalpost> journalpost;
    private String saksaar;
    private @Valid Date saksdato;
    private String sakssekvensnummer;
    private @Valid Date utlaantDato;
}
