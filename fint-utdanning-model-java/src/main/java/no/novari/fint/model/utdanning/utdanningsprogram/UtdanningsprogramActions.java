package no.novari.fint.model.utdanning.utdanningsprogram;

import java.util.Arrays;
import java.util.List;

public enum UtdanningsprogramActions {
  GET_ARSTRINN,
  GET_ALL_ARSTRINN,
  UPDATE_ARSTRINN,
  GET_PROGRAMOMRADE,
  GET_ALL_PROGRAMOMRADE,
  UPDATE_PROGRAMOMRADE,
  GET_PROGRAMOMRADEMEDLEMSKAP,
  GET_ALL_PROGRAMOMRADEMEDLEMSKAP,
  UPDATE_PROGRAMOMRADEMEDLEMSKAP,
  GET_SKOLE,
  GET_ALL_SKOLE,
  UPDATE_SKOLE,
  GET_UTDANNINGSPROGRAM,
  GET_ALL_UTDANNINGSPROGRAM,
  UPDATE_UTDANNINGSPROGRAM;

  /**
   * Gets a list of all enums as string
   *
   * @return A string list of all enums
   */
  public static List<String> getActions() {
    return Arrays.asList(
        Arrays.stream(UtdanningsprogramActions.class.getEnumConstants())
            .map(Enum::name)
            .toArray(String[]::new));
  }
}
