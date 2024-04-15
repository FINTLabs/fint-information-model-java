package no.fint.model.felles;

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
import no.fint.model.FintMainObject;
import no.fint.model.FintIdentifikator;
import no.fint.model.FintRelation;
import no.fint.model.felles.kompleksedatatyper.Adresse;
import java.util.Date;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.felles.kompleksedatatyper.Personnavn;
import no.fint.model.felles.basisklasser.Aktor;

import static no.fint.model.FintMultiplicity.ONE_TO_ONE;
import static no.fint.model.FintMultiplicity.ONE_TO_MANY;
import static no.fint.model.FintMultiplicity.NONE_TO_ONE;
import static no.fint.model.FintMultiplicity.NONE_TO_MANY;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Person extends Aktor  implements FintMainObject {
    @Getter
    public enum Relasjonsnavn implements FintRelation {
            STATSBORGERSKAP("statsborgerskap", "no.fint.model.felles.kodeverk.iso.Landkode", NONE_TO_MANY),
            KOMMUNE("kommune", "no.fint.model.felles.kodeverk.Kommune", NONE_TO_ONE),
            KJONN("kjonn", "no.fint.model.felles.kodeverk.iso.Kjonn", NONE_TO_ONE),
            FORELDREANSVAR("foreldreansvar", "no.fint.model.felles.Person", NONE_TO_MANY),
            MALFORM("malform", "no.fint.model.felles.kodeverk.iso.Sprak", NONE_TO_ONE),
            PERSONALRESSURS("personalressurs", "no.fint.model.administrasjon.personal.Personalressurs", NONE_TO_ONE),
            MORSMAL("morsmal", "no.fint.model.felles.kodeverk.iso.Sprak", NONE_TO_ONE),
            PARORENDE("parorende", "no.fint.model.felles.Kontaktperson", NONE_TO_MANY),
            FORELDRE("foreldre", "no.fint.model.felles.Person", NONE_TO_MANY),
            LARLING("larling", "no.fint.model.utdanning.larling.Larling", NONE_TO_MANY),
            ELEV("elev", "no.fint.model.utdanning.elev.Elev", NONE_TO_ONE),
            OTUNGDOM("otungdom", "no.fint.model.utdanning.ot.OtUngdom", NONE_TO_ONE);
	
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
	public Map<String, FintIdentifikator> getIdentifikators() {
    	Map<String, FintIdentifikator> identifikators = new HashMap<>();
		identifikators.put("fodselsnummer", this.fodselsnummer);
    
    	return identifikators;
	}
	@JsonIgnore
	private final List<FintRelation> relations = new ArrayList<>(List.of(Relasjonsnavn.values()));
    private String bilde;
    private @Valid Adresse bostedsadresse;
    private Date fodselsdato;
    @NotNull
    private @Valid Identifikator fodselsnummer;
    @NotNull
    private @Valid Personnavn navn;
}
