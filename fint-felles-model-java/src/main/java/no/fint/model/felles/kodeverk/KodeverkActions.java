package no.fint.model.felles.kodeverk;

import java.util.Arrays;
import java.util.List;

public enum KodeverkActions {
	
	GET_FYLKE,
	GET_ALL_FYLKE,
	UPDATE_FYLKE,
	GET_KOMMUNE,
	GET_ALL_KOMMUNE,
	UPDATE_KOMMUNE,
	GET_VALUTA,
	GET_ALL_VALUTA,
	UPDATE_VALUTA
	;


    /**
     * Gets a list of all enums as string
     *
     * @return A string list of all enums
     */
    public static List<String> getActions() {
        return Arrays.asList(
                Arrays.stream(KodeverkActions.class.getEnumConstants()).map(Enum::name).toArray(String[]::new)
        );
    }

}

