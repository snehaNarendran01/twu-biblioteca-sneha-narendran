package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

class UserTest {
    @Test
    void shouldBeAbleToPrintDetailsOfUser() throws IOException {
        UserOutput userOutput = mock(UserOutput.class);
        User user = new User("Jim", "jim12@gmail.com", "9391049708", userOutput);
        String expected = "Name: Jim\nEmail-id: jim12@gmail.com\nContact Number: 9391049708\n";

        user.printInformation();

        verify(userOutput, times(1)).print(expected);
    }

    @Test
    void shouldBeAbleToPrintDetailsOfAnyUser() throws IOException {
        UserOutput userOutput = mock(UserOutput.class);
        User user = new User("Raj", "rajPramod@gmail.com", "9492097899", userOutput);
        String expected = "Name: Raj\nEmail-id: rajPramod@gmail.com\nContact Number: 9492097899\n";

        user.printInformation();

        verify(userOutput, times(1)).print(expected);
    }
}