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
    void shouldReturnTitleOfMultipleBooks() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Book famousFive = new Book("Famous Five", "Enid Mary Blyton", Year.of(1942));
        Book harryPotter = new Book("Harry Potter", "J.K Rowling", Year.of(1997));
        ArrayList<Book> books = new ArrayList<>(Arrays.asList(famousFive, harryPotter));

        String expected = "Famous Five\nHarry Potter\n";
        BookViewer bookViewer = new BookViewer();

        bookViewer.printBookDetails(books);

        assertEquals(expected, byteArrayOutputStream.toString());
    }
}