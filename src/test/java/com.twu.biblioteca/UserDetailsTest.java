package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

class UserDetailsTest {
    @Test
    void shouldNotDisplayIfUserIsNotValidated() throws IOException {
        User user = mock(User.class);
        Validator validator = mock(Validator.class);
        when(validator.isValid()).thenReturn(false);
        when(validator.isValid()).thenReturn(false);
        UserDetails userDetails = new UserDetails(user, validator);

        userDetails.execute();

        verify(user, times(0)).printInformation();
    }
}