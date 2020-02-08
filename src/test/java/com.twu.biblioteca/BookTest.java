package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {
    @Test
    void shouldReturnTitleOfSingleBook() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Book book = new Book("Famous Five", "Enid Mary Blyton", Year.of(1942));
        String expected = "Title: Famous Five";

        book.printTitle();

        assertEquals(expected, byteArrayOutputStream.toString());
    }
    @Test
    void shouldReturnAuthorOfSingleBook() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Book book = new Book("Famous Five", "Enid Mary Blyton", Year.of(1942));
        String expected = "Author: Enid Mary Blyton";

        book.printAuthorName();

        assertEquals(expected, byteArrayOutputStream.toString());
    }


}