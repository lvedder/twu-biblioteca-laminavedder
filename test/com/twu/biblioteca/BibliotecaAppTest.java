package com.twu.biblioteca;

import org.junit.Test;

import static com.twu.biblioteca.BibliotecaApp.books;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class BibliotecaAppTest {

    @Test
    public void returnWelcomeMessageTest() {
        assertThat(BibliotecaApp.welcomeMessage(), is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"));
    }

    @Test
    public void printBookListTest() {
        //given
        String fakeListOfBooks = "The Big Five For Life" + "\t\t" + "John Strelecky" + "\t\t" + "2008\n" +
                "The Why Are You Here Cafe" + "\t\t" + "John Strelecky" + "\t\t" + "2003\n";

        BibliotecaApp.setUpBooks();

        //when
        String result = BibliotecaApp.listOfBooks();

        //then
        assertThat(result, is(fakeListOfBooks));
    }
}
