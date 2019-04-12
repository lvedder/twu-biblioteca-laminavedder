package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LibraryTest {

    @Test
    public void printBookListTest() {
        //given
        ArrayList<Book> books = new ArrayList<Book>();
            books.add(new Book("The Big Five For Life", "John Strelecky", "2008"));
            books.add(new Book("The Why Are You Here Cafe", "John Strelecky", "2003"));

        String fakeListOfBooks = "1" + "\t\t" + "The Big Five For Life" + "\t\t" + "John Strelecky" + "\t\t" + "2008\n" +
                "2" + "\t\t" + "The Why Are You Here Cafe" + "\t\t" + "John Strelecky" + "\t\t" + "2003\n";

        //when
        String result = new Library(books).listOfBooks();

        //then
        assertThat(result, is(fakeListOfBooks));
    }

    @Test
    public void shouldReturnTrueIfBookIsInLibTest() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("The Big Five For Life", "John Strelecky", "2008"));
        books.add(new Book("The Why Are You Here Cafe", "John Strelecky", "2003"));

        Library library = new Library(books);

        assertThat(library.hasBook("The Big Five For Life"), is(true));
    }

    @Test
    public void shouldReturnFalseIfBookIsInLibTest() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("The Big Five For Life", "John Strelecky", "2008"));
        books.add(new Book("The Why Are You Here Cafe", "John Strelecky", "2003"));

        Library library = new Library(books);

        assertThat(library.hasBook("The Big Four For Life"), is(false));
    }

    @Test
    public void deleteBookFromLibrary() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("The Big Five For Life", "John Strelecky", "2008"));
        books.add(new Book("The Why Are You Here Cafe", "John Strelecky", "2003"));

        Library library = new Library(books);

        String updatedLibrary = "1" + "\t\t" + "The Why Are You Here Cafe" + "\t\t" + "John Strelecky" + "\t\t" + "2003\n";

        assertThat(library.removeBook("The Big Five For Life"), is(updatedLibrary));
    }
}

