package no.fint.model.utdanning.elev;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
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
    public enum Relasjonsnavn {
            ELEV,
            SIDEMAL,
            KATEGORI,
            KROPPSOVING,
            SKOLE,
            AVBRUDDSARSAK,
            FRAVARSREGISTRERINGER,
            FAGGRUPPEMEDLEMSKAP,
            SKOLEAR,
            BASISGRUPPE,
            BASISGRUPPEMEDLEMSKAP,
            UNDERVISNINGSGRUPPEMEDLEMSKAP,
            VURDERING,
            SLUTTORDENSVURDERING,
            KONTAKTLARERGRUPPE,
            UNDERVEISFAGVURDERING,
            HALVARSFAGVURDERING,
            SLUTTFAGVURDERING,
            PERSONGRUPPEMEDLEMSKAP,
            EKSAMENSGRUPPEMEDLEMSKAP,
            KONTAKTLARERGRUPPEMEDLEMSKAP,
            ELEVFRAVAR,
            TILRETTELEGGING,
            HALVARSORDENSVURDERING,
            PROGRAMOMRADE,
            FRAVAR,
            PROGRAMOMRADEMEDLEMSKAP,
            UNDERVEISORDENSVURDERING,
            EKSAMENSGRUPPE,
            UNDERVISNINGSGRUPPE
    }

    private List<@Valid Anmerkninger> anmerkninger;
    private Date avbruddsdato;
    private @Valid Periode gyldighetsperiode;
    private Boolean hovedskole;
    private Boolean tosprakligFagopplaring;
}
