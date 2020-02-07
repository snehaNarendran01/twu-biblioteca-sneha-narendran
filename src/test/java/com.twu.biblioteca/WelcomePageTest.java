package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WelcomePageTest {
    @Test
    void shouldReturnTheWelcomeMessageWhenTheApplicationStarts() {
        WelcomePage welcomePage = new WelcomePage();
        String welcomeMessage = welcomePage.getWelcomeMessage();
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", welcomeMessage);
    }
}