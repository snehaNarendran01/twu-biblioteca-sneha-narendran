package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserDetailsTest {
    @Test
    void shouldThrowInvalidOptionExceptionIfTriedToViewDetailsBeforeLogin() throws IOException {
        UserDetails userDetails = new UserDetails(mock(User.class));
        Validator validator = mock(Validator.class);
        when(validator.isValid()).thenReturn(true);

        Assertions.assertThrows(InvalidOptionException.class, userDetails::getOptionBeforeLogin);
    }
}