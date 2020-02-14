package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CheckoutMoviesTest {
    @Test
    void shouldThrowInvalidOptionExceptionIfTriedToViewDetailsBeforeLogin() throws IOException {
        CheckoutMovies checkoutMovies = new CheckoutMovies(mock(MovieList.class));
        Validator validator = mock(Validator.class);
        when(validator.isValid()).thenReturn(false);

        Assertions.assertThrows(InvalidOptionException.class, checkoutMovies::getOptionBeforeLogin);
    }

}