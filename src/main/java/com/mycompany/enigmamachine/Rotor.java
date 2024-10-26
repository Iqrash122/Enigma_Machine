package com.mycompany.enigmamachine;

public class Rotor {
    private String wiring;
    private String notch;
    private int position;
    private int ringSetting;

    public Rotor(String wiring, String notch, int position, int ringSetting) {
        this.wiring = wiring;
        this.notch = notch;
        this.position = position;
        this.ringSetting = ringSetting;
    }

    public char forward(char c) {
        int index = (c - 'A' + position - ringSetting + 26) % 26;
        return wiring.charAt(index);
    }

    public char backward(char c) {
        int index = (wiring.indexOf(c) - position + ringSetting + 26) % 26;
        return (char) (index + 'A');
    }

    public void rotate() {
        position = (position + 1) % 26;
    }

    public boolean atNotch() {
        return notch.indexOf((char) ('A' + position)) != -1;
    }

    public int getPosition() {
        return position;
    }
}
