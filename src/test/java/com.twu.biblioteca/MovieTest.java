package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Year;

import static org.mockito.Mockito.*;

class MovieTest {
    Console console = mock(Console.class);

    @Test
    void shouldPrintDetailsOfTheMovie() throws IOException {
        Movie lifeOfPi = new Movie("Life Of Pi", Year.of(2012), "Ang Lee", "9.5", console);
        String expected = "Title: Life Of Pi Year of Release: 2012 Name of Director: Ang Lee Rating: 9.5\n";

        lifeOfPi.printDetails();

        verify(console, times(1)).print(expected);
    }

    @Test
    void shouldPrintDetailsOfAnotherBook() throws IOException {
        Movie dumbo = new Movie("Dumbo", Year.of(2019), "Tim Burton", "7", console);
        String expectedDumboDetails = "Title: Dumbo Year of Release: 2019 Name of Director: Tim Burton Rating: 7\n";

        dumbo.printDetails();

        verify(console, times(1)).print(expectedDumboDetails);
    }
}