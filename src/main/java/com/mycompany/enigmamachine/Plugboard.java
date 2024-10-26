package com.mycompany.enigmamachine;

import java.util.HashMap;
import java.util.Map;

public class Plugboard {
    private Map<Character, Character> wiring;

    public Plugboard(String pairs) {
        wiring = new HashMap<>();
        for (int i = 0; i < pairs.length(); i += 2) {
            char a = pairs.charAt(i);
            char b = pairs.charAt(i + 1);
            wiring.put(a, b);
            wiring.put(b, a);
        }
    }

    public char swap(char c) {
        return wiring.getOrDefault(c, c);
    }
}
