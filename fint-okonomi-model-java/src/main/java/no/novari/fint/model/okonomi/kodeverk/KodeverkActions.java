package no.novari.fint.model.okonomi.kodeverk;

import java.util.Arrays;
import java.util.List;

public enum KodeverkActions {
  GET_MERVERDIAVGIFT,
  GET_ALL_MERVERDIAVGIFT,
  UPDATE_MERVERDIAVGIFT,
  GET_VARE,
  GET_ALL_VARE,
  UPDATE_VARE;

  /**
   * Gets a list of all enums as string
   *
   * @return A string list of all enums
   */
  public static List<String> getActions() {
    return Arrays.asList(
        Arrays.stream(KodeverkActions.class.getEnumConstants())
            .map(Enum::name)
            .toArray(String[]::new));
  }
}
