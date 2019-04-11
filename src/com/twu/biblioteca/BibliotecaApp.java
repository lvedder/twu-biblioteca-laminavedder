package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    static ArrayList<Book> books = new ArrayList<Book>();

    public static void main(String[] args) {
        setUpBooks();
        System.out.println(welcomeMessage());
        System.out.println(listOfBooks());
    }

    public static void setUpBooks() {
        books.add(new Book("The Big Five For Life", "John Strelecky", "2008"));
        books.add(new Book("The Why Are You Here Cafe", "John Strelecky", "2003"));
//        books.add(new Book("The Alchemist", "Paulo Coelho", "1988"));
    }

    public static String welcomeMessage() {
        String msg = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        return msg;
    }

    public static String listOfBooks() {
        String bookList = "";
        for(Book book : books) {
            bookList = bookList + book.toString() + "\n";
        }
        return bookList;
    }
}