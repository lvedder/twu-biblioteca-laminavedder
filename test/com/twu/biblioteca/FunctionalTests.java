package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class FunctionalTests {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private final ByteArrayInputStream inContent = new ByteArrayInputStream("1\n6".getBytes());
    private final ByteArrayInputStream errInput = new ByteArrayInputStream("0\n6".getBytes());
    private final ByteArrayInputStream exitInput = new ByteArrayInputStream("6".getBytes());
    private final ByteArrayInputStream selectInput = new ByteArrayInputStream("2\nThe Why Are You Here Cafe\n6".getBytes());
    private final ByteArrayInputStream nonExistInput = new ByteArrayInputStream("2\nThe Alchemist\n2\nThe Alchemist\n6".getBytes());
    private final ByteArrayInputStream returnInput = new ByteArrayInputStream("2\nThe Alchemist\n3\nThe Alchemist\n1\n6\n".getBytes());
    private final ByteArrayInputStream returnErrInput = new ByteArrayInputStream("3\nXYZ\n1\n6".getBytes());
    private final ByteArrayInputStream movieInput = new ByteArrayInputStream("4\n6".getBytes());
    private final ByteArrayInputStream borrowMovieInput = new ByteArrayInputStream("5\nInception\n6".getBytes());
    private final InputStream originalIn = System.in;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        System.setIn(originalIn);
    }

    @Test
    public void welcomeMessageUiTest() {
        System.setIn(inContent);
        BibliotecaApp.main(new String[0]);
        assertThat(outContent.toString(), containsString(BibliotecaApp.welcomeMessage()));
    }

    @Test
    public void optionSelectTest() {
        System.setIn(inContent);
        BibliotecaApp.main(new String[0]);
        assertThat(outContent.toString(), containsString("The Big Five For Life" + "\t\t" + "John Strelecky" + "\t\t" + "2008\n"));
    }

    @Test
    public void invalidOptionTest() {
        System.setIn(errInput);
        BibliotecaApp.main(new String[0]);
        assertThat(outContent.toString(), containsString("Please select a valid option!"));
    }

    @Test
    public void exitProgramTest() {
        System.setIn(exitInput);
        BibliotecaApp.main(new String[0]);
        assertThat(outContent.toString(), containsString("Goodbye. Thank you for using Biblioteca!"));
    }

    @Test
    public void selectBookTest() {
        System.setIn(selectInput);
        BibliotecaApp.main(new String[0]);
        assertThat(outContent.toString(), containsString("Which book would you like to borrow? Please provide a title."));
    }

    @Test
    public void book1IsNotAvailableTest() {
        System.setIn(nonExistInput);
        BibliotecaApp.main(new String[0]);
        assertThat(outContent.toString(), containsString("Sorry, that book is not available"));
    }

    @Test
    public void returnBookTest() {
        System.setIn(returnInput);
        BibliotecaApp.main(new String[0]);
        assertThat(outContent.toString(), containsString("3\t\tThe Alchemist"));
    }

    @Test
    public void returnBookMessageTest() {
        System.setIn(returnInput);
        BibliotecaApp.main(new String[0]);
        assertThat(outContent.toString(), containsString("Thank you for returning the book."));
    }

    @Test
    public void failingReturnBookMessageTest() {
        System.setIn(returnErrInput);
        BibliotecaApp.main(new String[0]);
        assertThat(outContent.toString(), containsString("That is not a valid book to return."));
    }

    @Test
    public void listMoviesTest() {
        System.setIn(movieInput);
        BibliotecaApp.main(new String[0]);
        assertThat(outContent.toString(), containsString("2\t\tInterstellar\t\tChristopher Nolan\t\t2014\t\t8"));
    }

    @Test
    public void borrowMovieTest() {
        System.setIn(borrowMovieInput);
        BibliotecaApp.main(new String[0]);
        assertThat(outContent.toString(), containsString("Thank you for lending a movie with Biblioteca App"));
    }
}
