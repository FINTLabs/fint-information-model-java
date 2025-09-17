package no.novari.fint.model.ressurs.eiendel;

import java.util.Arrays;
import java.util.List;

public enum EiendelActions {
	
	GET_APPLIKASJON,
	GET_ALL_APPLIKASJON,
	UPDATE_APPLIKASJON,
	GET_APPLIKASJONSRESSURS,
	GET_ALL_APPLIKASJONSRESSURS,
	UPDATE_APPLIKASJONSRESSURS,
	GET_APPLIKASJONSRESSURSTILGJENGELIGHET,
	GET_ALL_APPLIKASJONSRESSURSTILGJENGELIGHET,
	UPDATE_APPLIKASJONSRESSURSTILGJENGELIGHET
	;


    /**
     * Gets a list of all enums as string
     *
     * @return A string list of all enums
     */
    public static List<String> getActions() {
        return Arrays.asList(
                Arrays.stream(EiendelActions.class.getEnumConstants()).map(Enum::name).toArray(String[]::new)
        );
    }

}

