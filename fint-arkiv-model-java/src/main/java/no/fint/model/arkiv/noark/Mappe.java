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
import no.fint.model.arkiv.noark.Klasse;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.arkiv.noark.Merknad;
import no.fint.model.arkiv.noark.Part;
import no.fint.model.arkiv.noark.Skjerming;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class Mappe implements FintAbstractObject {
    public enum Relasjonsnavn {
            AVSLUTTETAV,
            OPPRETTETAV,
            ARKIVDEL
    }

    private Date avsluttetDato;
    private String beskrivelse;
    private List<@Valid Klasse> klasse;
    private @Valid Identifikator mappeId;
    private List<@Valid Merknad> merknad;
    private List<String> noekkelord;
    private String offentligTittel;
    private Date opprettetDato;
    private List<@Valid Part> part;
    private @Valid Skjerming skjerming;
    private @Valid Identifikator systemId;
    private String tittel;
}
