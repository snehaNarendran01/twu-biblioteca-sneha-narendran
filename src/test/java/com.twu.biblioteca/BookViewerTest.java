package com.twu.biblioteca;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

class BookViewerTest {
    @Test
    void shouldDisplayTheDetailsOfMultipleBooks() throws IOException {
        UserOutput userOutput = mock(UserOutput.class);
        String expectedFamousFive = "Title: Famous Five Author: Enid Mary Blyton Year Of Publish: 1942\n";
        String expectedHarryPotter = "Title: Harry Potter Author: J.K. Rowling Year Of Publish: 1997\n";

        BookViewer bookViewer = new BookViewer(userOutput);

        bookViewer.printBookDetails();

        Mockito.verify(userOutput, times(1)).print(expectedFamousFive);
        verify(userOutput, times(1)).print(expectedHarryPotter);
    }
}