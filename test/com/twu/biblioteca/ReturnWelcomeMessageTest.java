package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReturnWelcomeMessageTest {

    @Test
    public void shouldReturnAWelcomeMessage() {
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", BibliotecaApp.welcomeMessage());
    }
}
