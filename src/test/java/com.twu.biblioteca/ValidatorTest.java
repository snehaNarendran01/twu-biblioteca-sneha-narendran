package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ValidatorTest {
    UserInput userInput = mock(UserInput.class);
    UserOutput userOutput = mock(UserOutput.class);

    @Test
    void shouldReturnFalseIfIsNotValidIfTheCredentialsAreWrong() throws IOException {
        when(userInput.scanLibraryNumber()).thenReturn("123-4567");
        when(userInput.scanUserPassword()).thenReturn("pass1234");

        Validator validator = new Validator(userInput, userOutput);

        assertFalse(validator.isValid());
    }

    @Test
    void shouldReturnTrueIfUserCredentialsAreCorrect() throws IOException {
        when(userInput.scanLibraryNumber()).thenReturn("017-1998");
        when(userInput.scanUserPassword()).thenReturn("pass1234");

        Validator validator = new Validator(userInput, userOutput);

        assertTrue(validator.isValid());
    }
}