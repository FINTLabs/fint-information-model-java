package no.fint.model.arkiv.noark;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.FintComplexDatatypeObject;
import no.fint.model.arkiv.noark.Avskrivning;
import java.util.Date;
import no.fint.model.arkiv.noark.Registrering;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Journalpost extends Registrering implements FintComplexDatatypeObject {
    @Getter
    public enum Relasjonsnavn {
            JOURNALPOSTTYPE("no.fint.model.arkiv.kodeverk.JournalpostType", "1"),
            JOURNALSTATUS("no.fint.model.arkiv.kodeverk.JournalStatus", "1"),
            JOURNALENHET("no.fint.model.arkiv.noark.AdministrativEnhet", "0..1");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }
    }


	public Map<String, Identifikator> getIdentifikators() {
    	Map<String, Identifikator> identifikators = new HashMap<>();
		identifikators.putAll(super.getIdentifikators());
    
    	return identifikators;
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
