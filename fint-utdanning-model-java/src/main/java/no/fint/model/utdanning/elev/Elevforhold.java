package no.fint.model.utdanning.elev;

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
import no.fint.model.utdanning.vurdering.Anmerkninger;
import java.util.Date;
import no.fint.model.felles.kompleksedatatyper.Periode;
import no.fint.model.utdanning.basisklasser.Utdanningsforhold;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Elevforhold extends Utdanningsforhold implements FintMainObject {
    @Getter
    public enum Relasjonsnavn {
            ELEV("no.fint.model.utdanning.elev.Elev", "1"),
            SIDEMAL("no.fint.model.utdanning.kodeverk.Fagmerknad", "0..*"),
            KATEGORI("no.fint.model.utdanning.kodeverk.Elevkategori", "0..1"),
            KROPPSOVING("no.fint.model.utdanning.kodeverk.Fagmerknad", "0..1"),
            SKOLE("no.fint.model.utdanning.utdanningsprogram.Skole", "1"),
            AVBRUDDSARSAK("no.fint.model.utdanning.kodeverk.Avbruddsarsak", "0..*"),
            FRAVARSREGISTRERINGER("no.fint.model.utdanning.vurdering.Elevfravar", "0..1"),
            FAGGRUPPEMEDLEMSKAP("no.fint.model.utdanning.timeplan.Faggruppemedlemskap", "0..*"),
            SKOLEAR("no.fint.model.utdanning.kodeverk.Skolear", "0..1"),
            BASISGRUPPE("no.fint.model.utdanning.elev.Basisgruppe", "0..*"),
            BASISGRUPPEMEDLEMSKAP("no.fint.model.utdanning.elev.Basisgruppemedlemskap", "0..*"),
            UNDERVISNINGSGRUPPEMEDLEMSKAP("no.fint.model.utdanning.timeplan.Undervisningsgruppemedlemskap", "0..*"),
            VURDERING("no.fint.model.utdanning.vurdering.Vurdering", "0..*"),
            SLUTTORDENSVURDERING("no.fint.model.utdanning.vurdering.Sluttordensvurdering", "0..*"),
            KONTAKTLARERGRUPPE("no.fint.model.utdanning.elev.Kontaktlarergruppe", "0..*"),
            UNDERVEISFAGVURDERING("no.fint.model.utdanning.vurdering.Underveisfagvurdering", "0..*"),
            HALVARSFAGVURDERING("no.fint.model.utdanning.vurdering.Halvarsfagvurdering", "0..*"),
            SLUTTFAGVURDERING("no.fint.model.utdanning.vurdering.Sluttfagvurdering", "0..*"),
            PERSONGRUPPEMEDLEMSKAP("no.fint.model.utdanning.elev.Persongruppemedlemskap", "0..*"),
            EKSAMENSGRUPPEMEDLEMSKAP("no.fint.model.utdanning.vurdering.Eksamensgruppemedlemskap", "0..*"),
            KONTAKTLARERGRUPPEMEDLEMSKAP("no.fint.model.utdanning.elev.Kontaktlarergruppemedlemskap", "0..*"),
            ELEVFRAVAR("no.fint.model.utdanning.vurdering.Fravarsoversikt", "0..*"),
            TILRETTELEGGING("no.fint.model.utdanning.elev.Elevtilrettelegging", "0..*"),
            HALVARSORDENSVURDERING("no.fint.model.utdanning.vurdering.Halvarsordensvurdering", "0..*"),
            PROGRAMOMRADE("no.fint.model.utdanning.utdanningsprogram.Programomrade", "0..1"),
            FRAVAR("no.fint.model.utdanning.vurdering.Fravar", "0..*"),
            PROGRAMOMRADEMEDLEMSKAP("no.fint.model.utdanning.utdanningsprogram.Programomrademedlemskap", "0..*"),
            UNDERVEISORDENSVURDERING("no.fint.model.utdanning.vurdering.Underveisordensvurdering", "0..*"),
            EKSAMENSGRUPPE("no.fint.model.utdanning.vurdering.Eksamensgruppe", "0..*"),
            UNDERVISNINGSGRUPPE("no.fint.model.utdanning.timeplan.Undervisningsgruppe", "0..*");
	
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


    private List<@Valid Anmerkninger> anmerkninger;
    private Date avbruddsdato;
    private @Valid Periode gyldighetsperiode;
    private Boolean hovedskole;
    private Boolean tosprakligFagopplaring;
}
