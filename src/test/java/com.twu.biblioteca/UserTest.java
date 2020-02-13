package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

class UserTest {
    Console console = mock(Console.class);
    @Test
    void shouldBeAbleToPrintDetailsOfUser() throws IOException {
        User user = new User("Jim", "jim12@gmail.com", "9391049708", console);
        String expected = "Name: Jim\nEmail-id: jim12@gmail.com\nContact Number: 9391049708\n";

        user.printInformation();

        verify(console, times(1)).print(expected);
    }

    @Test
    void shouldBeAbleToPrintDetailsOfAnyUser() throws IOException {
        User user = new User("Raj", "rajPramod@gmail.com", "9492097899", console);
        String expected = "Name: Raj\nEmail-id: rajPramod@gmail.com\nContact Number: 9492097899\n";

        user.printInformation();

        verify(console, times(1)).print(expected);
    }
}