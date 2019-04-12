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
}
