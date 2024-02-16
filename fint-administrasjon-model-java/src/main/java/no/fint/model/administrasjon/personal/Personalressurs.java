package no.fint.model.administrasjon.personal;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.felles.kompleksedatatyper.Periode;
import java.util.Date;
import no.fint.model.felles.kompleksedatatyper.Kontaktinformasjon;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Personalressurs implements FintMainObject {
    @Getter
    public enum Relasjonsnavn {
            PERSONALRESSURSKATEGORI("no.fint.model.administrasjon.kodeverk.Personalressurskategori", "1"),
            ARBEIDSFORHOLD("no.fint.model.administrasjon.personal.Arbeidsforhold", "0..*"),
            PERSON("no.fint.model.felles.Person", "1"),
            STEDFORTREDER("no.fint.model.administrasjon.fullmakt.Fullmakt", "0..*"),
            FULLMAKT("no.fint.model.administrasjon.fullmakt.Fullmakt", "0..*"),
            LEDER("no.fint.model.administrasjon.organisasjon.Organisasjonselement", "0..*"),
            PERSONALANSVAR("no.fint.model.administrasjon.personal.Arbeidsforhold", "0..*"),
            SKOLERESSURS("no.fint.model.utdanning.elev.Skoleressurs", "0..1");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }
    }


	public Map<String, Identifikator> getIdentifikators() {
    	Map<String, Identifikator> identifikators = new HashMap<>();
		identifikators.put("ansattnummer", this.ansattnummer);
		identifikators.put("brukernavn", this.brukernavn);
		identifikators.put("systemId", this.systemId);
    
    	return identifikators;
	}


    @NotNull
    private @Valid Identifikator ansattnummer;
    @NotNull
    private @Valid Periode ansettelsesperiode;
    private Date ansiennitet;
    private @Valid Identifikator brukernavn;
    private String jobbtittel;
    private @Valid Kontaktinformasjon kontaktinformasjon;
    private @Valid Identifikator systemId;
}
