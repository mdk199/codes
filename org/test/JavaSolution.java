package org.test;

import java.util.*;

public class JavaSolution {

    private static Set<String> dictionary = new HashSet(Arrays.asList("This", "is", "long", "a", "valid", "validated", "ate", "one", "sentence", "sent"));
    private static Stack<String> stack = new Stack<>();

    public static void main(String args[]) throws Exception {

        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner s = new Scanner(System.in);
        String input = s.next();
        s.close();

        // Thisisalongsentencevalidatedone

        int i = 0, j = 1;
        while (j <= input.length()) {
            String word = input.substring(i, j);
            if (dictionary.contains(word)) {
                stack.push(word);
                i = j;
            } else {
                if (j == input.length() && !word.isEmpty()) {
                    j = i + 1;
                    i = i - stack.pop().length();
                } else {
                    j++;
                }
            }
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}

