package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WelcomePageTest {
    @Test
    void shouldReturnTheWelcomeMessageWhenTheApplicationStarts() {
        WelcomePage welcomePage=new WelcomePage();
        String welcomeMessage = welcomePage.getWelcomeMessage();
        Assertions.assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!",welcomeMessage);
    }
}