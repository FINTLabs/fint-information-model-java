package no.novari.fint.model.utdanning.timeplan;

import java.util.Arrays;
import java.util.List;

public enum TimeplanActions {
	
	GET_EKSAMEN,
	GET_ALL_EKSAMEN,
	UPDATE_EKSAMEN,
	GET_FAG,
	GET_ALL_FAG,
	UPDATE_FAG,
	GET_FAGGRUPPE,
	GET_ALL_FAGGRUPPE,
	UPDATE_FAGGRUPPE,
	GET_FAGGRUPPEMEDLEMSKAP,
	GET_ALL_FAGGRUPPEMEDLEMSKAP,
	UPDATE_FAGGRUPPEMEDLEMSKAP,
	GET_ROM,
	GET_ALL_ROM,
	UPDATE_ROM,
	GET_TIME,
	GET_ALL_TIME,
	UPDATE_TIME,
	GET_UNDERVISNINGSGRUPPE,
	GET_ALL_UNDERVISNINGSGRUPPE,
	UPDATE_UNDERVISNINGSGRUPPE,
	GET_UNDERVISNINGSGRUPPEMEDLEMSKAP,
	GET_ALL_UNDERVISNINGSGRUPPEMEDLEMSKAP,
	UPDATE_UNDERVISNINGSGRUPPEMEDLEMSKAP
	;


    /**
     * Gets a list of all enums as string
     *
     * @return A string list of all enums
     */
    public static List<String> getActions() {
        return Arrays.asList(
                Arrays.stream(TimeplanActions.class.getEnumConstants()).map(Enum::name).toArray(String[]::new)
        );
    }

}

