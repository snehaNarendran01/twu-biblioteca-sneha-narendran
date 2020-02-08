package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WelcomePageTest {
    @Test
    void shouldReturnTheWelcomeMessageWhenTheApplicationStarts() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        WelcomePage welcomePage = new WelcomePage();
        String expected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        welcomePage.getWelcomeMessage();

        assertEquals(expected, byteArrayOutputStream.toString());
    }
}