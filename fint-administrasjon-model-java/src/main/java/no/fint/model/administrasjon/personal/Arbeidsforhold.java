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
import no.fint.model.felles.kompleksedatatyper.Periode;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Arbeidsforhold implements FintMainObject {
    @Getter
    public enum Relasjonsnavn {
            AKTIVITET("no.fint.model.administrasjon.kodeverk.Aktivitet", "0..1"),
            ANLEGG("no.fint.model.administrasjon.kodeverk.Anlegg", "0..1"),
            ANSVAR("no.fint.model.administrasjon.kodeverk.Ansvar", "0..1"),
            ARBEIDSFORHOLDSTYPE("no.fint.model.administrasjon.kodeverk.Arbeidsforholdstype", "0..1"),
            ART("no.fint.model.administrasjon.kodeverk.Art", "0..1"),
            DIVERSE("no.fint.model.administrasjon.kodeverk.Diverse", "0..1"),
            FORMAL("no.fint.model.administrasjon.kodeverk.Formal", "0..1"),
            FUNKSJON("no.fint.model.administrasjon.kodeverk.Funksjon", "0..1"),
            KONTRAKT("no.fint.model.administrasjon.kodeverk.Kontrakt", "0..1"),
            LOPENUMMER("no.fint.model.administrasjon.kodeverk.Lopenummer", "0..1"),
            OBJEKT("no.fint.model.administrasjon.kodeverk.Objekt", "0..1"),
            PROSJEKT("no.fint.model.administrasjon.kodeverk.Prosjekt", "0..1"),
            RAMME("no.fint.model.administrasjon.kodeverk.Ramme", "0..1"),
            STILLINGSKODE("no.fint.model.administrasjon.kodeverk.Stillingskode", "0..1"),
            TIMERPERUKE("no.fint.model.administrasjon.kodeverk.Uketimetall", "0..1"),
            ARBEIDSLOKASJON("no.fint.model.administrasjon.organisasjon.Arbeidslokasjon", "0..1"),
            ARBEIDSSTED("no.fint.model.administrasjon.organisasjon.Organisasjonselement", "1"),
            PERSONALLEDER("no.fint.model.administrasjon.personal.Personalressurs", "0..1"),
            FASTLONN("no.fint.model.administrasjon.personal.Fastlonn", "0..*"),
            FASTTILLEGG("no.fint.model.administrasjon.personal.Fasttillegg", "0..*"),
            FRAVAR("no.fint.model.administrasjon.personal.Fravar", "0..*"),
            LONN("no.fint.model.administrasjon.personal.Lonn", "0..*"),
            VARIABELLONN("no.fint.model.administrasjon.personal.Variabellonn", "0..*"),
            PERSONALRESSURS("no.fint.model.administrasjon.personal.Personalressurs", "1"),
            UNDERVISNINGSFORHOLD("no.fint.model.utdanning.elev.Undervisningsforhold", "0..1");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }
    }


	public Map<String, Identifikator> getIdentifikators() {
    	Map<String, Identifikator> identifikators = new HashMap<>();
		identifikators.put("systemId", this.systemId);
    
    	return identifikators;
	}


    @NotNull
    private Long ansettelsesprosent;
    private @Valid Periode arbeidsforholdsperiode;
    @NotNull
    private Long arslonn;
    @NotNull
    private @Valid Periode gyldighetsperiode;
    @NotNull
    private Boolean hovedstilling;
    @NotNull
    private Long lonnsprosent;
    @NotBlank
    private String stillingsnummer;
    private String stillingstittel;
    @NotNull
    private @Valid Identifikator systemId;
    @NotNull
    private Long tilstedeprosent;
}
