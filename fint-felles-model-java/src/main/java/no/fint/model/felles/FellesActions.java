// Built from tag v3.5.0

package no.fint.model.felles;

import java.util.Arrays;
import java.util.List;

public enum FellesActions {
	
	GET_KONTAKTPERSON,
	GET_ALL_KONTAKTPERSON,
	UPDATE_KONTAKTPERSON,
	GET_PERSON,
	GET_ALL_PERSON,
	UPDATE_PERSON
	;


    /**
     * Gets a list of all enums as string
     *
     * @return A string list of all enums
     */
    public static List<String> getActions() {
        return Arrays.asList(
                Arrays.stream(FellesActions.class.getEnumConstants()).map(Enum::name).toArray(String[]::new)
        );
    }

}

