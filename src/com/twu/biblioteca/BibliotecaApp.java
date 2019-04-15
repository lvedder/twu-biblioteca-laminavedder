package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static final int LIST_BOOK_OPTION = 1;
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
        System.out.println("1\tList of books");
        System.out.println("2\tSelect a book");
        System.out.println("3\tReturn a book");
        System.out.println("6\tExit Biblioteca");
        System.out.println("Please enter your choice:");
        int choice;
        do {
            System.out.println("What would you like to do next?");
            choice = input.nextInt();
            switch (choice) {
                case LIST_BOOK_OPTION:
                    System.out.println(new Library(books).listOfBooks());
                    break;
                case 2:
                    System.out.println(new Library(books).listOfBooks());
                    System.out.println("Which book would you like to borrow? Please provide a title.");
                    String bookChoice;
                    do {
                        bookChoice = input.nextLine();
                    } while (bookChoice.equals(""));
                    Library lib = new Library(books);
                    if (lib.hasBook(bookChoice)) {
                        System.out.println("Thank you! Enjoy the book");
                        lib.removeBook(bookChoice);
                    } else {
                        System.out.println("Sorry, that book is not available");
                    }
                    break;
                case 3:
                    System.out.println("Which book would you like to return? Please provide the title.");
                    String returnBook;
                    do {
                        returnBook = input.nextLine();
                    } while (returnBook.equals(""));
                    Library currLib = new Library(books);
                    if (currLib.isNotInStock(returnBook)) {
                        currLib.addBook(returnBook);
                        System.out.println("Thank you for returning the book.");
                    } else {
                        System.out.println("That is not a valid book to return.");
                    }
                case 6:
                    System.out.println("Goodbye. Thank you for using Biblioteca!");
                    break;
                default:
                    System.out.println("Please select a valid option!");
            }
        } while (choice != 6);
    }
}