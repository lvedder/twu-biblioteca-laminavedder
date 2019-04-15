package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library(ArrayList books) {
        this.books = books;
    }

    public String listOfBooks() {
        String bookList = "";
        for(int i = 0; i < books.size(); i++) {
            if (books.get(i).isInStock()) {
                bookList = bookList + (i + 1) + "\t\t" + books.get(i).getTitle() + "\t\t" + books.get(i).getAuthor() + "\t\t" + books.get(i).getYear() + "\n";
            }
        }
        return bookList;
    }


    public Boolean hasBook(String title) {
        for(Book book: books) {
            if (book.getTitle().equals(title) && book.isInStock()) {
                return true;
            }
        }
        return false;
    }

    public String removeBook(String title) {
        for(Book book: books) {
            if (book.getTitle().equals(title)) {
                book.setInStock(false);
                listOfBooks();
                System.out.println(listOfBooks());
            }
        }
        return listOfBooks();
    }
}
