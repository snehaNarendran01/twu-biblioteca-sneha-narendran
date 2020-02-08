package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {
    @Test
    void shouldReturnASingleBookWhenThereIsSingleBookInLibrary() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Book book = new Book("Famous Five", "Enid Mary Blyton", Year.of(1942));
        String expected = "Famous Five";

        book.printTitle();

        assertEquals(expected, byteArrayOutputStream.toString());
    }

    @Test
    void shouldReturnListOfBooksWhenLibraryHasMultipleBooks() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Book famousFive = new Book("Famous Five", "Enid Mary Blyton", Year.of(1942));
        Book harryPotter=new Book("Harry Potter","J.K Rowling",Year.of(1997));
        String expected="Famous Five\nHarry Potter\n";

        famousFive.printTitle();
        harryPotter.printTitle();

        assertEquals(expected,byteArrayOutputStream.toString());
    }
}