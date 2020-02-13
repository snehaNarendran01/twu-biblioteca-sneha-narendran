package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Year;

import static org.mockito.Mockito.*;

class BookTest {
    @Test
    void shouldReturnTheBookDetails() throws IOException {
        Console console = mock(Console.class);
        Book book = new Book("Famous Five", "Enid Mary Blyton", Year.of(1942), console);
        String expected = "Title: Famous Five Author: Enid Mary Blyton Year Of Publish: 1942\n";

        book.printInformation();

        verify(console, times(1)).print(expected);
    }
}