package no.fint.model.ressurs.datautstyr;

import java.util.Arrays;
import java.util.List;

public enum DatautstyrActions {
	
	GET_DIGITALENHET,
	GET_ALL_DIGITALENHET,
	UPDATE_DIGITALENHET,
	GET_ENHETSGRUPPE,
	GET_ALL_ENHETSGRUPPE,
	UPDATE_ENHETSGRUPPE,
	GET_ENHETSGRUPPEMEDLEMSKAP,
	GET_ALL_ENHETSGRUPPEMEDLEMSKAP,
	UPDATE_ENHETSGRUPPEMEDLEMSKAP
	;


    /**
     * Gets a list of all enums as string
     *
     * @return A string list of all enums
     */
    public static List<String> getActions() {
        return Arrays.asList(
                Arrays.stream(DatautstyrActions.class.getEnumConstants()).map(Enum::name).toArray(String[]::new)
        );
    }

}

