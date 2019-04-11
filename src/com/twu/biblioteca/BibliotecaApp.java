package com.twu.biblioteca;

public class BibliotecaApp {

    private static boolean hasPrintedWelcome = false;

    public static void main(String[] args) {
        if (!hasPrintedWelcome) {
        System.out.println(welcomeMessage());
        hasPrintedWelcome = true;
    }
        else {
            System.out.println("Goodbye");
        }
    }

    public static String welcomeMessage() {
        String msg = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        return msg;
    }
}