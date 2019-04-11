package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println(welcomeMessage());
        System.out.println(listOfBooks());
    }

    public static String welcomeMessage() {
        String msg = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        return msg;
    }

    public static String listOfBooks() {
        return "The Big Five For Life\nDas Cafe am Rande der Welt\nThe Alchemist";
    }
}