package no.novari.fint.model.okonomi.regnskap;

import java.util.Arrays;
import java.util.List;

public enum RegnskapActions {
	
	GET_LEVERANDOR,
	GET_ALL_LEVERANDOR,
	UPDATE_LEVERANDOR,
	GET_LEVERANDORGRUPPE,
	GET_ALL_LEVERANDORGRUPPE,
	UPDATE_LEVERANDORGRUPPE,
	GET_POSTERING,
	GET_ALL_POSTERING,
	UPDATE_POSTERING,
	GET_TRANSAKSJON,
	GET_ALL_TRANSAKSJON,
	UPDATE_TRANSAKSJON
	;


    /**
     * Gets a list of all enums as string
     *
     * @return A string list of all enums
     */
    public static List<String> getActions() {
        return Arrays.asList(
                Arrays.stream(RegnskapActions.class.getEnumConstants()).map(Enum::name).toArray(String[]::new)
        );
    }

}

