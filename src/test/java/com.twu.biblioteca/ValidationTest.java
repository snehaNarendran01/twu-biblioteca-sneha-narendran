package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ValidationTest {
    @Test
    void shouldReturnFalseIfIsNotValidIfTheCredentialsAreWrong() throws IOException {
        UserInput userInput = mock(UserInput.class);
        when(userInput.scanLibraryNumber()).thenReturn("123-4567");
        when(userInput.scanUserPassword()).thenReturn("pass1234");

        Validation validation = new Validation(userInput);

        assertFalse(validation.isValid());
    }

    @Test
    void shouldReturnTrueIfUserCredentialsAreCorrect() throws IOException {
        UserInput userInput = mock(UserInput.class);
        when(userInput.scanLibraryNumber()).thenReturn("017-1998");
        when(userInput.scanUserPassword()).thenReturn("pass1234");

        Validation validation = new Validation(userInput);

        assertTrue(validation.isValid());
    }
}