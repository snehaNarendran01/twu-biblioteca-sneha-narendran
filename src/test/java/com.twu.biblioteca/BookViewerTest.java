package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookViewerTest {
    @Test
    void shouldDisplayTheDetailsOfMultipleBooks() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        String expected = "Title: Famous Five Author: Enid Mary Blyton Year Of Publish: 1942\nTitle: " +
                "Harry Potter Author: J.K. Rowling Year Of Publish: 1997\n";

        BookViewer bookViewer = new BookViewer();

        bookViewer.printBookDetails();

        assertEquals(expected, byteArrayOutputStream.toString());
    }
}