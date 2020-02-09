package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookViewerTest {
    @Test
    void shouldDisplayTheDetailsOfMultipleBooks() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        ArrayList<Book> bookList = new ArrayList<>(Arrays.asList(new Book("Famous Five",
                "Enid Mary Blyton", Year.of(1942)), new Book("Harry Potter", "J.K. Rowling", Year.of(1997))));
        String expected = "Title: Famous Five Author: Enid Mary Blyton Year Of Publish: 1942\nTitle: " +
                "Harry Potter Author: J.K. Rowling Year Of Publish: 1997\n";

        BookViewer bookViewer = new BookViewer(bookList);

        bookViewer.printBookDetails();

        assertEquals(expected, byteArrayOutputStream.toString());
    }
}