package no.fint.model.arkiv.noark;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintAbstractObject;
import java.util.Date;
import no.fint.model.arkiv.noark.Dokumentbeskrivelse;
import no.fint.model.arkiv.noark.Klasse;
import no.fint.model.arkiv.noark.Korrespondansepart;
import no.fint.model.arkiv.noark.Merknad;
import no.fint.model.arkiv.noark.Part;
import no.fint.model.arkiv.noark.Skjerming;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class Registrering implements FintAbstractObject {
    public enum Relasjonsnavn {
            ADMINISTRATIVENHET("no.fint.model.arkiv.noark.AdministrativEnhet", "0..1"),
            ARKIVDEL("no.fint.model.arkiv.noark.Arkivdel", "0..1"),
            SAKSBEHANDLER("no.fint.model.arkiv.noark.Arkivressurs", "0..1"),
            ARKIVERTAV("no.fint.model.arkiv.noark.Arkivressurs", "1"),
            OPPRETTETAV("no.fint.model.arkiv.noark.Arkivressurs", "1");
	
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

    private @Valid Date arkivertDato;
    private String beskrivelse;
    private List<@Valid Dokumentbeskrivelse> dokumentbeskrivelse;
    private List<String> forfatter;
    private @Valid Klasse klasse;
    private List<@Valid Korrespondansepart> korrespondansepart;
    private List<@Valid Merknad> merknad;
    private List<String> nokkelord;
    private String offentligTittel;
    private @Valid Date opprettetDato;
    private List<@Valid Part> part;
    private List<String> referanseArkivDel;
    private String registreringsId;
    private @Valid Skjerming skjerming;
    @NotBlank
    private String tittel;
}
