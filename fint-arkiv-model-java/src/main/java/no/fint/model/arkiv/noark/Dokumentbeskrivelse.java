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
import no.fint.model.arkiv.noark.Dokumentobjekt;
import java.util.Date;
import no.fint.model.arkiv.noark.Part;
import no.fint.model.arkiv.noark.Skjerming;

import static no.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Dokumentbeskrivelse  implements FintComplexDatatypeObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
            DOKUMENTSTATUS("dokumentstatus", "no.fint.model.arkiv.kodeverk.DokumentStatus", ONE_TO_ONE),
            DOKUMENTTYPE("dokumentType", "no.fint.model.arkiv.kodeverk.DokumentType", ONE_TO_ONE),
            TILKNYTTETREGISTRERINGSOM("tilknyttetRegistreringSom", "no.fint.model.arkiv.kodeverk.TilknyttetRegistreringSom", ONE_TO_MANY),
            TILKNYTTETAV("tilknyttetAv", "no.fint.model.arkiv.noark.Arkivressurs", ONE_TO_ONE),
            OPPRETTETAV("opprettetAv", "no.fint.model.arkiv.noark.Arkivressurs", ONE_TO_ONE);
	
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
    private String beskrivelse;
    private Long dokumentnummer;
    private List<@Valid Dokumentobjekt> dokumentobjekt;
    private List<String> forfatter;
    private @Valid Date opprettetDato;
    private List<@Valid Part> part;
    private List<String> referanseArkivdel;
    private @Valid Skjerming skjerming;
    private @Valid Date tilknyttetDato;
    @NotBlank
    private String tittel;
}
