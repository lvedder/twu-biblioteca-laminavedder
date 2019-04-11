package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library(ArrayList books) {
        this.books = books;
    }

    public String listOfBooks() {
        String bookList = "";
        for(Book book : books) {
            bookList = bookList + book.toString() + "\n";
        }
        return bookList;
    }
}
