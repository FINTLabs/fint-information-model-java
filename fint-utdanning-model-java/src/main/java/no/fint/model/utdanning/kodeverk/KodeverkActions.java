package no.fint.model.utdanning.kodeverk;

import java.util.Arrays;
import java.util.List;

public enum KodeverkActions {
	
	GET_AVBRUDDSARSAK,
	GET_ALL_AVBRUDDSARSAK,
	UPDATE_AVBRUDDSARSAK,
	GET_EKSAMENSFORM,
	GET_ALL_EKSAMENSFORM,
	UPDATE_EKSAMENSFORM,
	GET_ELEVKATEGORI,
	GET_ALL_ELEVKATEGORI,
	UPDATE_ELEVKATEGORI,
	GET_FAGMERKNAD,
	GET_ALL_FAGMERKNAD,
	UPDATE_FAGMERKNAD,
	GET_FRAVARSTYPE,
	GET_ALL_FRAVARSTYPE,
	UPDATE_FRAVARSTYPE,
	GET_KARAKTERSKALA,
	GET_ALL_KARAKTERSKALA,
	UPDATE_KARAKTERSKALA,
	GET_KARAKTERSTATUS,
	GET_ALL_KARAKTERSTATUS,
	UPDATE_KARAKTERSTATUS,
	GET_SKOLEAR,
	GET_ALL_SKOLEAR,
	UPDATE_SKOLEAR,
	GET_SKOLEEIERTYPE,
	GET_ALL_SKOLEEIERTYPE,
	UPDATE_SKOLEEIERTYPE,
	GET_TERMIN,
	GET_ALL_TERMIN,
	UPDATE_TERMIN,
	GET_TILRETTELEGGING,
	GET_ALL_TILRETTELEGGING,
	UPDATE_TILRETTELEGGING
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

