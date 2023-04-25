package no.fint.model.utdanning.ot;

import java.util.Arrays;
import java.util.List;

public enum OtActions {
	
	GET_OTUNGDOM,
	GET_ALL_OTUNGDOM,
	UPDATE_OTUNGDOM
	;


    /**
     * Gets a list of all enums as string
     *
     * @return A string list of all enums
     */
    public static List<String> getActions() {
        return Arrays.asList(
                Arrays.stream(OtActions.class.getEnumConstants()).map(Enum::name).toArray(String[]::new)
        );
    }

}

