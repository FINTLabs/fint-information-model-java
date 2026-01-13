package no.novari.fint.model.administrasjon.organisasjon;

import java.util.Arrays;
import java.util.List;

public enum OrganisasjonActions {
	
	GET_ARBEIDSLOKASJON,
	GET_ALL_ARBEIDSLOKASJON,
	UPDATE_ARBEIDSLOKASJON,
	GET_ORGANISASJONSELEMENT,
	GET_ALL_ORGANISASJONSELEMENT,
	UPDATE_ORGANISASJONSELEMENT
	;


    /**
     * Gets a list of all enums as string
     *
     * @return A string list of all enums
     */
    public static List<String> getActions() {
        return Arrays.asList(
                Arrays.stream(OrganisasjonActions.class.getEnumConstants()).map(Enum::name).toArray(String[]::new)
        );
    }

}

