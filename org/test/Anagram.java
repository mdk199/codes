package org.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Anagram {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String lhs = s.next();
    String rhs = s.next();
    System.out.println(isAnagram(lhs, rhs));
  }

  private static boolean isAnagram(String lhs, String rhs) {
    Map<Character, Integer> charFrequencyMap = new HashMap<>();
    int ONE = 1;
      if (Objects.isNull(lhs)
          || Objects.isNull(rhs)
          || lhs.length() != rhs.length()) {
          return false;
      }

    lhs = lhs.toLowerCase();
    rhs = rhs.toLowerCase();
    for (char c : lhs.toCharArray()) {
      if (!charFrequencyMap.containsKey(c)) {
        charFrequencyMap.put(c, ONE);
      } else {
        charFrequencyMap.put(c, charFrequencyMap.get(c) + ONE);
      }
    }

    for (char c : rhs.toCharArray()) {
      if (charFrequencyMap.containsKey(c)) {
        charFrequencyMap.put(c, charFrequencyMap.get(c) - ONE);
      } else {
        return false;
      }
        if (charFrequencyMap.get(c) == 0) {
            charFrequencyMap.remove(c);
        }
    }
    return charFrequencyMap.isEmpty();
  }
}
