package no.fint.model.felles.kodeverk.iso;

import java.util.Arrays;
import java.util.List;

public enum IsoActions {
	
	GET_KJONN,
	GET_ALL_KJONN,
	UPDATE_KJONN,
	GET_LANDKODE,
	GET_ALL_LANDKODE,
	UPDATE_LANDKODE,
	GET_SPRAK,
	GET_ALL_SPRAK,
	UPDATE_SPRAK
	;


    /**
     * Gets a list of all enums as string
     *
     * @return A string list of all enums
     */
    public static List<String> getActions() {
        return Arrays.asList(
                Arrays.stream(IsoActions.class.getEnumConstants()).map(Enum::name).toArray(String[]::new)
        );
    }

}

