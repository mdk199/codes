package org.test;

import java.util.*;


/**
 * Programme to generate terms
 * 1, 11, 21, 1211, 111221, 312211...
 */
public class LookAndSay {

    public static void main(String[] args) {
        System.out.print("ENTER THE NTH NO TO GENERATE NTH TERM : ");
        Scanner scan = new Scanner(System.in);
        Integer next = scan.nextInt();
        Long start = System.currentTimeMillis();
        System.out.println(generateTerm(next));
        Long end = System.currentTimeMillis();
        System.out.println("TIME TAKEN : " + (end - start));
    }

    private static String generateTerm(Integer k) {
        List<Character> characters = new ArrayList<>();
        if (k == 1) {
            characters.add('1');
            return String.valueOf(characters);
        }

        if (k == 2) {
            characters.add('1');
            characters.add('1');
            return String.valueOf(characters);
        }

        List<Character> temp = Arrays.asList('1', '1');
        while (k > 2) {
            Character[] chars = new Character[temp.size()];
            temp.toArray(chars);
            int i = 0, count = 1;
            while (i < chars.length) {
                if (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                    count += 1;
                } else {
                    characters.add(String.valueOf(count).charAt(0));
                    characters.add(chars[i]);
                    count = 1;
                }
                i++;
            }
            temp = new ArrayList<>(characters);
            characters = new ArrayList<>();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for( Character c : temp){
            sb.append(c.toString());
        }
        return sb.toString();
    }

}