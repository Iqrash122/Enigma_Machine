package com.mycompany.enigmamachine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create rotors
        Rotor rotor1 = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", "Q", 0, 0);
        Rotor rotor2 = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", "E", 0, 0);
        Rotor rotor3 = new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", "V", 0, 0);

        // Create reflector
        Reflector reflector = new Reflector("YRUHQSLDPXNGOKMIEBFZCWVJAT");

        // Create plugboard
        Plugboard plugboard = new Plugboard("ABCD");

        // Create Enigma machine
        EnigmaMachine enigma = new EnigmaMachine(new Rotor[]{rotor1, rotor2, rotor3}, reflector, plugboard);

        // Create Scanner for user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter message to encrypt: ");
        String message = scanner.nextLine();

        // Encrypt message
        String encrypted = enigma.encrypt(message);
        System.out.println("Encrypted: " + encrypted);

        // Reset rotor positions for decryption
        rotor1 = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", "Q", 0, 0);
        rotor2 = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", "E", 0, 0);
        rotor3 = new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", "V", 0, 0);

        enigma = new EnigmaMachine(new Rotor[]{rotor1, rotor2, rotor3}, reflector, plugboard);

        // Decrypt message
        String decrypted = enigma.encrypt(encrypted);
        System.out.println("Decrypted: " + decrypted);

        scanner.close();
    }
}
