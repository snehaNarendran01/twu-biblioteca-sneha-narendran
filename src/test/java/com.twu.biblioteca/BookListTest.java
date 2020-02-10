package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class BookListTest {
    private ByteArrayOutputStream byteArrayOutputStream;

    private void initializeOutputStream() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    void shouldBeAbleToCheckoutBookIfItExistInList() {
        String input = "Harry Potter";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BookList bookList = new BookList();
        try {
            bookList.checkout();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void shouldBeAbleToGetAnUnsuccessfulMessageIfBookIfItDoesNotExistInList() {
        initializeOutputStream();
        String input = "ssdsdsdsdd";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BookList bookList = new BookList();
        String expectedUnSuccessfulMessage = "Sorry, that book is not available";

        bookList.checkout();

        assertEquals(expectedUnSuccessfulMessage, byteArrayOutputStream.toString());
    }

    @Test
    void shouldBeAbleToGetASuccessMessageIfTheBookWasRemovedSuccessfully() {
        initializeOutputStream();
        String input = "Harry Potter";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BookList bookList = new BookList();
        String expectedSuccessMessage = "Thank you! Enjoy the book";

        bookList.checkout();

        assertEquals(expectedSuccessMessage, byteArrayOutputStream.toString());
    }

    @Test
    void shouldBeAbleToGetAnUnsuccessfulMessageIfBookCouldNotBeReturned() {
        initializeOutputStream();
        String input = "Harry Poter";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BookList bookList = new BookList();
        String expectedUnSuccessfulMessage = "That is not a valid book to return.";

        bookList.returnBook();

        assertEquals(expectedUnSuccessfulMessage, byteArrayOutputStream.toString());
    }

    @Test
    void shouldBeAbleToGetASuccessMessageIfBookIsReturned() {
        initializeOutputStream();
        String input = "Harry Potter";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BookList bookList = new BookList();
        String expectedUnSuccessfulMessage = "Thank you for returning the book";

        bookList.returnBook();

        assertEquals(expectedUnSuccessfulMessage, byteArrayOutputStream.toString());
    }

}