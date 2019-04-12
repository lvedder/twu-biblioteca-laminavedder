package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BibliotecaAppTest {

    @Test
    public void returnWelcomeMessageTest() {
        assertThat(BibliotecaApp.welcomeMessage(), is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"));
    }
}
