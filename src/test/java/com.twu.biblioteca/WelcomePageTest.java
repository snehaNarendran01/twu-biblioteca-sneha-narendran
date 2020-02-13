package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

class WelcomePageTest {
    Console console = mock(Console.class);

    @Test
    void shouldReturnTheWelcomeMessageWhenTheApplicationStarts() throws IOException {
        WelcomePage welcomePage = new WelcomePage(console);
        String expected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        welcomePage.getWelcomeMessage();

        verify(console, times(1)).print(expected);
    }
}