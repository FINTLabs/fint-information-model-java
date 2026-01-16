package no.novari.fint.model.arkiv.noark;

import java.util.Arrays;
import java.util.List;

public enum NoarkActions {
  GET_ADMINISTRATIVENHET,
  GET_ALL_ADMINISTRATIVENHET,
  UPDATE_ADMINISTRATIVENHET,
  GET_ARKIVDEL,
  GET_ALL_ARKIVDEL,
  UPDATE_ARKIVDEL,
  GET_ARKIVRESSURS,
  GET_ALL_ARKIVRESSURS,
  UPDATE_ARKIVRESSURS,
  GET_AUTORISASJON,
  GET_ALL_AUTORISASJON,
  UPDATE_AUTORISASJON,
  GET_DOKUMENTFIL,
  GET_ALL_DOKUMENTFIL,
  UPDATE_DOKUMENTFIL,
  GET_KLASSIFIKASJONSSYSTEM,
  GET_ALL_KLASSIFIKASJONSSYSTEM,
  UPDATE_KLASSIFIKASJONSSYSTEM,
  GET_SAK,
  GET_ALL_SAK,
  UPDATE_SAK,
  GET_TILGANG,
  GET_ALL_TILGANG,
  UPDATE_TILGANG;

  /**
   * Gets a list of all enums as string
   *
   * @return A string list of all enums
   */
  public static List<String> getActions() {
    return Arrays.asList(
        Arrays.stream(NoarkActions.class.getEnumConstants())
            .map(Enum::name)
            .toArray(String[]::new));
  }
}
