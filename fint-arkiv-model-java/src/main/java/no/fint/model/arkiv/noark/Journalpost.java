package no.fint.model.arkiv.noark;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
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
import no.fint.model.arkiv.noark.Avskrivning;
import java.util.Date;
import no.fint.model.arkiv.noark.Registrering;

import static no.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Journalpost extends Registrering  implements FintComplexDatatypeObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
            JOURNALPOSTTYPE("journalposttype", "no.fint.model.arkiv.kodeverk.JournalpostType", ONE_TO_ONE),
            JOURNALSTATUS("journalstatus", "no.fint.model.arkiv.kodeverk.JournalStatus", ONE_TO_ONE),
            JOURNALENHET("journalenhet", "no.fint.model.arkiv.noark.AdministrativEnhet", NONE_TO_ONE);
	
		private final String name;
        private final String packageName;
        private final FintMultiplicity multiplicity;

        private Relasjonsnavn(String name, String packageName, FintMultiplicity multiplicity) {
			this.name = name;
            this.packageName = packageName;
            this.multiplicity = multiplicity;
        }
    }

	@JsonIgnore
	private final List<FintRelation> relations = new ArrayList<>(List.of(Relasjonsnavn.values()));
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
