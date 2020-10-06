// Built from tag v3.6.0-rc-1

package no.fint.model.arkiv.kulturminnevern;

import java.util.Arrays;
import java.util.List;

public enum KulturminnevernActions {
	
	GET_DISPENSASJONAUTOMATISKFREDAKULTURMINNE,
	GET_ALL_DISPENSASJONAUTOMATISKFREDAKULTURMINNE,
	UPDATE_DISPENSASJONAUTOMATISKFREDAKULTURMINNE,
	GET_TILSKUDDFARTOY,
	GET_ALL_TILSKUDDFARTOY,
	UPDATE_TILSKUDDFARTOY,
	GET_TILSKUDDFREDABYGNINGPRIVATEIE,
	GET_ALL_TILSKUDDFREDABYGNINGPRIVATEIE,
	UPDATE_TILSKUDDFREDABYGNINGPRIVATEIE
	;


    /**
     * Gets a list of all enums as string
     *
     * @return A string list of all enums
     */
    public static List<String> getActions() {
        return Arrays.asList(
                Arrays.stream(KulturminnevernActions.class.getEnumConstants()).map(Enum::name).toArray(String[]::new)
        );
    }

}

