package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

class BookViewerTest {
    @Test
    void shouldDisplayTheDetailsOfMultipleBooks() throws IOException {
        Console console = mock(Console.class);
        String expectedFamousFive = "Title: Famous Five Author: Enid Mary Blyton Year Of Publish: 1942\n";
        String expectedHarryPotter = "Title: Harry Potter Author: J.K. Rowling Year Of Publish: 1997\n";

        BookViewer bookViewer = new BookViewer(console);

        bookViewer.printBookDetails();

        verify(console, times(1)).print(expectedFamousFive);
        verify(console, times(1)).print(expectedHarryPotter);
    }
}