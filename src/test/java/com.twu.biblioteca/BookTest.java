package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.mockito.Mockito.*;

class BookTest {
    @Test
    void shouldReturnTheBookDetails() {
        UserOutput userOutput = mock(UserOutput.class);
        Book book = new Book("Famous Five", "Enid Mary Blyton", Year.of(1942), userOutput);
        String expected = "Title: Famous Five Author: Enid Mary Blyton Year Of Publish: 1942\n";

        book.printInformation();

        verify(userOutput, times(1)).print(expected);
    }
}