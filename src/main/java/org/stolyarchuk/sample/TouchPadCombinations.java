package org.stolyarchuk.sample;

import java.util.*;
import java.util.stream.Collectors;

public class TouchPadCombinations {

    private static final Map<Character, List<Character>> KEYBOARD = new HashMap<>();
    static {
        KEYBOARD.put('2', Arrays.asList('A', 'B', 'C'));
        KEYBOARD.put('3', Arrays.asList('D', 'E', 'F'));
        KEYBOARD.put('4', Arrays.asList('G', 'H', 'I'));
        KEYBOARD.put('5', Arrays.asList('J', 'K', 'L'));
        KEYBOARD.put('6', Arrays.asList('M', 'N', 'O'));
        KEYBOARD.put('7', Arrays.asList('P', 'Q', 'R', 'S'));
        KEYBOARD.put('8', Arrays.asList('T', 'U', 'V'));
        KEYBOARD.put('9', Arrays.asList('W', 'X', 'Y', 'Z'));
    }

    public static void main(String[] args) {
        List<String> strings = collect("2578", Collections.singletonList(""));
        System.out.println(strings);
    }

    private static List<String> collect(String input, List<String> parts) {
        if (! input.isEmpty()) {
            String nextInput = input.substring(1);
            char symbol = input.charAt(0);
            List<String> nextParts = parts.stream()
                    .map(part -> KEYBOARD.get(symbol).stream().map(next -> part + next).collect(Collectors.toList()))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
            return collect(nextInput, nextParts);
        }
        return parts;
    }

}
