package com.aldo.experiments.algorithms;

import java.util.*;

public class BracketsBalance {

    private static HashSet<Character> open = new HashSet<>(Arrays.asList('(', '[', '{', '<'));
    private static HashSet<Character> close = new HashSet<>(Arrays.asList(')', ']', '}', '>'));
    private static Map<Character, Character> matchingBrackets =
        new HashMap<Character, Character>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
            put('>', '<');
        }};



    private static Stack<Character> brackets;

    public static int hasBalancedBrackets(String str) {
        brackets = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            Character current = str.charAt(i);

            if (open.contains(current)) {
                brackets.add(current);
            } else if (close.contains(current)) {
                if (brackets.isEmpty() || !brackets.pop().equals(matchingBrackets.get(current))) {
                    return 0;
                }
            }
        }

        return brackets.isEmpty() ? 1 : 0;
    }
}
