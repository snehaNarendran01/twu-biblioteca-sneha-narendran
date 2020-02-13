package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ValidatorTest {
    Console console = mock(Console.class);

    @Test
    void shouldReturnFalseIfIsNotValidIfTheCredentialsAreWrong() throws IOException {
        when(console.scanLibraryNumber()).thenReturn("123-4567");
        when(console.scanUserPassword()).thenReturn("pass1234");

        Validator validator = new Validator(console);

        assertFalse(validator.isValid());
    }

    @Test
    void shouldReturnTrueIfUserCredentialsAreCorrect() throws IOException {
        when(console.scanLibraryNumber()).thenReturn("017-1998");
        when(console.scanUserPassword()).thenReturn("pass1234");

        Validator validator = new Validator(console);

        assertTrue(validator.isValid());
    }
}