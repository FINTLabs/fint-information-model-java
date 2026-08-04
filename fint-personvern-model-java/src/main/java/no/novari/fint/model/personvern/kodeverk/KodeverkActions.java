package no.novari.fint.model.personvern.kodeverk;

import java.util.Arrays;
import java.util.List;

public enum KodeverkActions {
	
	GET_BEHANDLINGSGRUNNLAG,
	GET_ALL_BEHANDLINGSGRUNNLAG,
	UPDATE_BEHANDLINGSGRUNNLAG,
	GET_PERSONOPPLYSNING,
	GET_ALL_PERSONOPPLYSNING,
	UPDATE_PERSONOPPLYSNING
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

