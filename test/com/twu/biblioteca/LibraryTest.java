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

        String fakeListOfBooks = "The Big Five For Life" + "\t\t" + "John Strelecky" + "\t\t" + "2008\n" +
                "The Why Are You Here Cafe" + "\t\t" + "John Strelecky" + "\t\t" + "2003\n";

        //when
        String result = new Library(books).listOfBooks();

        //then
        assertThat(result, is(fakeListOfBooks));
    }
}

