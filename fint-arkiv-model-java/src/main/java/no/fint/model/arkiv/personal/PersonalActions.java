package no.fint.model.arkiv.personal;

import java.util.Arrays;
import java.util.List;

public enum PersonalActions {
	
	GET_PERSONALMAPPE,
	GET_ALL_PERSONALMAPPE,
	UPDATE_PERSONALMAPPE
	;


    /**
     * Gets a list of all enums as string
     *
     * @return A string list of all enums
     */
    public static List<String> getActions() {
        return Arrays.asList(
                Arrays.stream(PersonalActions.class.getEnumConstants()).map(Enum::name).toArray(String[]::new)
        );
    }

}

