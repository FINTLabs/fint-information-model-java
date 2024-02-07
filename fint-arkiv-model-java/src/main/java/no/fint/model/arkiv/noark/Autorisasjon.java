package no.fint.model.arkiv.noark;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import no.fint.model.FintMainObject;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Autorisasjon implements FintMainObject {
    @Getter
    public enum Relasjonsnavn {
            TILGANGSRESTRIKSJON("no.fint.model.arkiv.kodeverk.Tilgangsrestriksjon", "1..*"),
            ADMINISTRATIVENHET("no.fint.model.arkiv.noark.AdministrativEnhet", "0..*"),
            ARKIVRESSURS("no.fint.model.arkiv.noark.Arkivressurs", "0..*");
	
        private final String typeName;
        private final String multiplicity;

        private Relasjonsnavn(String typeName, String multiplicity) {
            this.typeName = typeName;
            this.multiplicity = multiplicity;
        }
    }

    @NotNull
    private @Valid Identifikator systemId;
}
