package no.fint.model.okonomi.faktura;

import java.util.Arrays;
import java.util.List;

public enum FakturaActions {
	
	GET_FAKTURA,
	GET_ALL_FAKTURA,
	UPDATE_FAKTURA,
	GET_FAKTURAGRUNNLAG,
	GET_ALL_FAKTURAGRUNNLAG,
	UPDATE_FAKTURAGRUNNLAG,
	GET_FAKTURAUTSTEDER,
	GET_ALL_FAKTURAUTSTEDER,
	UPDATE_FAKTURAUTSTEDER
	;


    /**
     * Gets a list of all enums as string
     *
     * @return A string list of all enums
     */
    public static List<String> getActions() {
        return Arrays.asList(
                Arrays.stream(FakturaActions.class.getEnumConstants()).map(Enum::name).toArray(String[]::new)
        );
    }

}

