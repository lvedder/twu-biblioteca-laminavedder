package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    static ArrayList<Book> books = new ArrayList<Book>();

    public static void main(String[] args) {
        setUpBooks();
        System.out.println(welcomeMessage());
        getUserChoice();
    }

    private static void setUpBooks() {
        books.add(new Book("The Big Five For Life", "John Strelecky", "2008"));
        books.add(new Book("The Why Are You Here Cafe", "John Strelecky", "2003"));
        books.add(new Book("The Alchemist", "Paulo Coelho", "1988"));
    }

    public static String welcomeMessage() {
        String msg = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        return msg;
    }

    public static void getUserChoice() {
        Scanner input = new Scanner(System.in);
        System.out.println("1\t List of books");
        System.out.println("Please enter your choice:");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println(new Library(books).listOfBooks());
                break;
            default: System.out.println("Please select a valid option!");
        }
    }
}