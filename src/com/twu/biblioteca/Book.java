package com.twu.biblioteca;

public class Book {

    private String title;
    private String author;
    private String year;
    private boolean isInStock;

    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isInStock = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return title + "\t\t" + author + "\t\t" + year;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }

    public boolean isInStock() {
        return isInStock;
    }
}
