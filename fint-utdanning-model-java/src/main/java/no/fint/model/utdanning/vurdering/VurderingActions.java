package no.fint.model.utdanning.vurdering;

import java.util.Arrays;
import java.util.List;

public enum VurderingActions {
	
	GET_EKSAMENSGRUPPE,
	GET_ALL_EKSAMENSGRUPPE,
	UPDATE_EKSAMENSGRUPPE,
	GET_EKSAMENSGRUPPEMEDLEMSKAP,
	GET_ALL_EKSAMENSGRUPPEMEDLEMSKAP,
	UPDATE_EKSAMENSGRUPPEMEDLEMSKAP,
	GET_FRAVAR,
	GET_ALL_FRAVAR,
	UPDATE_FRAVAR,
	GET_KARAKTERVERDI,
	GET_ALL_KARAKTERVERDI,
	UPDATE_KARAKTERVERDI,
	GET_VURDERING,
	GET_ALL_VURDERING,
	UPDATE_VURDERING
	;


    /**
     * Gets a list of all enums as string
     *
     * @return A string list of all enums
     */
    public static List<String> getActions() {
        return Arrays.asList(
                Arrays.stream(VurderingActions.class.getEnumConstants()).map(Enum::name).toArray(String[]::new)
        );
    }

}

