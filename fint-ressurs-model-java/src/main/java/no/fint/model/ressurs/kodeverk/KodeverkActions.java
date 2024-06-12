package no.fint.model.ressurs.kodeverk;

import java.util.Arrays;
import java.util.List;

public enum KodeverkActions {
	
	GET_APPLIKASJONSKATEGORI,
	GET_ALL_APPLIKASJONSKATEGORI,
	UPDATE_APPLIKASJONSKATEGORI,
	GET_BRUKERTYPE,
	GET_ALL_BRUKERTYPE,
	UPDATE_BRUKERTYPE,
	GET_HANDHEVINGSTYPE,
	GET_ALL_HANDHEVINGSTYPE,
	UPDATE_HANDHEVINGSTYPE,
	GET_LISENSMODELL,
	GET_ALL_LISENSMODELL,
	UPDATE_LISENSMODELL,
	GET_PLATTFORM,
	GET_ALL_PLATTFORM,
	UPDATE_PLATTFORM
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

