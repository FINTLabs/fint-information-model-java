// Built from tag v3.5.0

package no.fint.model.administrasjon.fullmakt;

import java.util.Arrays;
import java.util.List;

public enum FullmaktActions {
	
	GET_FULLMAKT,
	GET_ALL_FULLMAKT,
	UPDATE_FULLMAKT,
	GET_ROLLE,
	GET_ALL_ROLLE,
	UPDATE_ROLLE
	;


    /**
     * Gets a list of all enums as string
     *
     * @return A string list of all enums
     */
    public static List<String> getActions() {
        return Arrays.asList(
                Arrays.stream(FullmaktActions.class.getEnumConstants()).map(Enum::name).toArray(String[]::new)
        );
    }

}

