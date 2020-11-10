package no.fint.model.arkiv.samferdsel;

import java.util.Arrays;
import java.util.List;

public enum SamferdselActions {
	
	GET_DROSJELOYVE,
	GET_ALL_DROSJELOYVE,
	UPDATE_DROSJELOYVE
	;


    /**
     * Gets a list of all enums as string
     *
     * @return A string list of all enums
     */
    public static List<String> getActions() {
        return Arrays.asList(
                Arrays.stream(SamferdselActions.class.getEnumConstants()).map(Enum::name).toArray(String[]::new)
        );
    }

}

