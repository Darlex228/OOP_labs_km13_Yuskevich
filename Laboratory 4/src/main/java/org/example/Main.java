package org.example;

public class Main {
    public static void main(String[] args) {
        Input i = new Input();
        Calculating c = new Calculating(i);
        System.out.print(c.check());
    }
}