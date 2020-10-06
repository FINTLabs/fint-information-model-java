// Built from tag v3.6.0-rc-1

package no.fint.model.utdanning.kodeverk;

import java.util.Arrays;
import java.util.List;

public enum KodeverkActions {
	
	GET_ELEVKATEGORI,
	GET_ALL_ELEVKATEGORI,
	UPDATE_ELEVKATEGORI,
	GET_FRAVARSTYPE,
	GET_ALL_FRAVARSTYPE,
	UPDATE_FRAVARSTYPE,
	GET_KARAKTERSKALA,
	GET_ALL_KARAKTERSKALA,
	UPDATE_KARAKTERSKALA,
	GET_SKOLEAR,
	GET_ALL_SKOLEAR,
	UPDATE_SKOLEAR,
	GET_SKOLEEIERTYPE,
	GET_ALL_SKOLEEIERTYPE,
	UPDATE_SKOLEEIERTYPE,
	GET_TERMIN,
	GET_ALL_TERMIN,
	UPDATE_TERMIN
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

