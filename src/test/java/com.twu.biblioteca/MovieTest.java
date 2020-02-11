package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Year;

import static org.mockito.Mockito.*;

class MovieTest {
    @Test
    void shouldPrintDetailsOfTheMovie() throws IOException {
        UserOutput userOutput = mock(UserOutput.class);
        Movie lifeOfPi = new Movie("Life Of Pi", Year.of(2012), "Ang Lee", "9.5", userOutput);
        String expected = "Title: Life Of Pi Year of Release: 2012 Name of Director: Ang Lee Rating: 9.5\n";

        lifeOfPi.printDetails();

        verify(userOutput, times(1)).print(expected);
    }

    @Test
    void shouldPrintDetailsOfAnotherBook() throws IOException {
        UserOutput userOutput = mock(UserOutput.class);
        Movie dumbo = new Movie("Dumbo", Year.of(2019), "Tim Burton", "7", userOutput);
        String expectedDumboDetails = "Title: Dumbo Year of Release: 2019 Name of Director: Tim Burton Rating: 7\n";

        dumbo.printDetails();

        verify(userOutput, times(1)).print(expectedDumboDetails);
    }
}