package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

class MovieListTest {
    private UserOutput userOutput = mock(UserOutput.class);
    private UserInput userInput = mock(UserInput.class);

    @Test
    void shouldBeAbleToCheckoutMovieIfItExistInList() throws IOException {
        when(userInput.scanMovieTitle()).thenReturn("Life Of Pi");
        MovieList movieList = new MovieList(userInput, userOutput);
        try {
            movieList.checkout("Life Of Pi");
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void shouldBeAbleToGetAnUnsuccessfulMessageIfMovieIfItDoesNotExistInList() throws IOException {
        MovieList movieList = new MovieList(userInput, userOutput);
        String expectedUnSuccessfulMessage = "Sorry, that movie is not available\n";

        movieList.checkout("Birds Of Prey");

        verify(userOutput, times(1)).print(expectedUnSuccessfulMessage);
    }

    @Test
    void shouldBeAbleToGetASuccessfulMessageIfMovieExistInList() throws IOException {
        MovieList movieList = new MovieList(userInput, userOutput);
        String expectedSuccessfulMessage = "Thank you! Enjoy the movie\n";

        movieList.checkout("Life Of Pi");

        verify(userOutput, times(1)).print(expectedSuccessfulMessage);
    }

    @Test
    void shouldNotBeAbleToCheckoutTheMovieTwice() throws IOException {
        MovieList movieList = new MovieList(userInput, userOutput);
        String expectedSuccessfulMessage = "Thank you! Enjoy the movie\n";
        String expectedUnSuccessfulMessage = "Sorry, that movie is not available\n";

        movieList.checkout("Life Of Pi");
        movieList.checkout("Life Of Pi");

        verify(userOutput, times(1)).print(expectedSuccessfulMessage);
        verify(userOutput, times(1)).print(expectedUnSuccessfulMessage);
    }
}