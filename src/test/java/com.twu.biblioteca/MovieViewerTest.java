package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

class MovieViewerTest {
    @Test
    void shouldReturnDetailsOfMultipleBooks() throws IOException {
        Console console = mock(Console.class);
        MovieViewer movieViewer = new MovieViewer(console);
        String expectedLifeOfPi = "Title: Life Of Pi Year of Release: 2012 Name of Director: Ang Lee Rating: 9.5\n";
        String expectedDumbo = "Title: Dumbo Year of Release: 2019 Name of Director: Tim Burton Rating: 7\n";

        movieViewer.printMovieDetails();

        verify(console, times(1)).print(expectedLifeOfPi);
        verify(console, times(1)).print(expectedDumbo);
    }
}