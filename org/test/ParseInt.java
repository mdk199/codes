package org.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseInt {

  public static void main(String[] args) {

    final String regex = "(([-,+]?)([0-9]*))";
    final String string = "+09970";

    final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
    final Matcher matcher = pattern.matcher(string);

    matcher.matches();

    while (matcher.find()) {
      System.out.println("Full match: " + matcher.group(0));
      for (int i = 1; i <= matcher.groupCount(); i++) {
        System.out.println("Group " + i + ": " + matcher.group(i));
      }
    }
  }
}
