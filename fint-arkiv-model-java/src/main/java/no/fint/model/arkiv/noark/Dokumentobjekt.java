package no.fint.model.arkiv.noark;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintComplexDatatypeObject;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Dokumentobjekt implements FintComplexDatatypeObject {
    public enum Relasjonsnavn {
            FILFORMAT("no.fint.model.arkiv.noark.Format", "0..1"),
            VARIANTFORMAT("no.fint.model.arkiv.noark.Variantformat", "1"),
            OPPRETTETAV("no.fint.model.arkiv.noark.Arkivressurs", "1"),
            REFERANSEDOKUMENTFIL("no.fint.model.arkiv.noark.Dokumentfil", "0..1");
	
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

    private String filstorrelse;
    @Deprecated
    private String format;
    private String formatDetaljer;
    private String sjekksum;
    private String sjekksumAlgoritme;
    private Long versjonsnummer;
}
