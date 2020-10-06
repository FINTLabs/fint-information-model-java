package no.fint.model.personvern.samtykke;

import java.util.Arrays;
import java.util.List;

public enum SamtykkeActions {
	
	GET_BEHANDLING,
	GET_ALL_BEHANDLING,
	UPDATE_BEHANDLING,
	GET_SAMTYKKE,
	GET_ALL_SAMTYKKE,
	UPDATE_SAMTYKKE,
	GET_TJENESTE,
	GET_ALL_TJENESTE,
	UPDATE_TJENESTE
	;


    /**
     * Gets a list of all enums as string
     *
     * @return A string list of all enums
     */
    public static List<String> getActions() {
        return Arrays.asList(
                Arrays.stream(SamtykkeActions.class.getEnumConstants()).map(Enum::name).toArray(String[]::new)
        );
    }

}

