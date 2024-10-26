package com.mycompany.enigmamachine;

public class EnigmaMachine {
    private Rotor[] rotors;
    private Reflector reflector;
    private Plugboard plugboard;

    public EnigmaMachine(Rotor[] rotors, Reflector reflector, Plugboard plugboard) {
        this.rotors = rotors;
        this.reflector = reflector;
        this.plugboard = plugboard;
    }

    public String encrypt(String message) {
        StringBuilder result = new StringBuilder();
        for (char c : message.toUpperCase().toCharArray()) {
            if (c < 'A' || c > 'Z') continue;

            // Step the rotors
            stepRotors();

            // Pass through plugboard
            c = plugboard.swap(c);

            // Forward pass through rotors
            for (Rotor rotor : rotors) {
                c = rotor.forward(c);
            }

            // Reflector
            c = reflector.reflect(c);

            // Backward pass through rotors
            for (int i = rotors.length - 1; i >= 0; i--) {
                c = rotors[i].backward(c);
            }

            // Pass through plugboard again
            c = plugboard.swap(c);

            result.append(c);
        }
        return result.toString();
    }

    private void stepRotors() {
        boolean stepNext = true;
        for (int i = 0; i < rotors.length; i++) {
            if (stepNext) {
                rotors[i].rotate();
                stepNext = rotors[i].atNotch();
            } else {
                break;
            }
        }
    }
}
