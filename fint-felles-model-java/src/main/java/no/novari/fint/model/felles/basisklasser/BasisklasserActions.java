package no.novari.fint.model.felles.basisklasser;

import java.util.Arrays;
import java.util.List;

public enum BasisklasserActions {
	
	;


    /**
     * Gets a list of all enums as string
     *
     * @return A string list of all enums
     */
    public static List<String> getActions() {
        return Arrays.asList(
                Arrays.stream(BasisklasserActions.class.getEnumConstants()).map(Enum::name).toArray(String[]::new)
        );
    }

}

