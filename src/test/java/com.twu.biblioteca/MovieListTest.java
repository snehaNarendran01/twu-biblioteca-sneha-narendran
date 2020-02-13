package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

class MovieListTest {
    private Console console = mock(Console.class);

    @Test
    void shouldBeAbleToCheckoutMovieIfItExistInList() throws IOException {
        when(console.scanMovieTitle()).thenReturn("Life Of Pi");
        MovieList movieList = new MovieList(console);
        try {
            movieList.checkout();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void shouldBeAbleToGetAnUnsuccessfulMessageIfMovieIfItDoesNotExistInList() throws IOException {
        when(console.scanMovieTitle()).thenReturn("Birds Of Prey");
        MovieList movieList = new MovieList(console);
        String expectedUnSuccessfulMessage = "Sorry, that movie is not available\n";

        movieList.checkout();

        verify(console, times(1)).print(expectedUnSuccessfulMessage);
    }

    @Test
    void shouldBeAbleToGetASuccessfulMessageIfMovieExistInList() throws IOException {
        MovieList movieList = new MovieList(console);
        when(console.scanMovieTitle()).thenReturn("Life Of Pi");
        String expectedSuccessfulMessage = "Thank you! Enjoy the movie\n";

        movieList.checkout();

        verify(console, times(1)).print(expectedSuccessfulMessage);
    }

    @Test
    void shouldNotBeAbleToCheckoutTheMovieTwice() throws IOException {
        MovieList movieList = new MovieList(console);
        when(console.scanMovieTitle()).thenReturn("Life Of Pi");
        String expectedSuccessfulMessage = "Thank you! Enjoy the movie\n";
        String expectedUnSuccessfulMessage = "Sorry, that movie is not available\n";

        movieList.checkout();
        movieList.checkout();

        verify(console, times(1)).print(expectedSuccessfulMessage);
        verify(console, times(1)).print(expectedUnSuccessfulMessage);
    }
}