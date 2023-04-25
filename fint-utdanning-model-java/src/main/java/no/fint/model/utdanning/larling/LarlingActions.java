package no.fint.model.utdanning.larling;

import java.util.Arrays;
import java.util.List;

public enum LarlingActions {
	
	GET_LARLING,
	GET_ALL_LARLING,
	UPDATE_LARLING
	;


    /**
     * Gets a list of all enums as string
     *
     * @return A string list of all enums
     */
    public static List<String> getActions() {
        return Arrays.asList(
                Arrays.stream(LarlingActions.class.getEnumConstants()).map(Enum::name).toArray(String[]::new)
        );
    }

}

