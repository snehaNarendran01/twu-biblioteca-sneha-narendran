package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;

class BookListTest {
    private ByteArrayOutputStream initializeOutputStream() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        return byteArrayOutputStream;
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
        ByteArrayOutputStream byteArrayOutputStream = initializeOutputStream();
        String input = "ssdsdsdsdd";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BookList bookList = new BookList();
        String expectedUnSuccessfulMessage = "Sorry, that book is not available";

        bookList.checkout();

        assertEquals(expectedUnSuccessfulMessage, byteArrayOutputStream.toString());
    }

    @Test
    void shouldBeAbleToGetASuccessMessageIfTheBookWasRemovedSuccessfully() {
        ByteArrayOutputStream byteArrayOutputStream = initializeOutputStream();
        String input = "Harry Potter";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BookList bookList = new BookList();
        String expectedSuccessMessage = "Thank you! Enjoy the book";

        bookList.checkout();

        assertEquals(expectedSuccessMessage, byteArrayOutputStream.toString());
    }

    @Test
    void shouldBeAbleToGetAnUnsuccessfulMessageIfBookCouldNotBeReturned() {
        ByteArrayOutputStream byteArrayOutputStream = initializeOutputStream();
        Book book = mock(Book.class);
        BookList bookList = new BookList();
        String expectedUnSuccessfulMessage = "That is not a valid book to return.";

        bookList.returnBook(book.getTitle());

        assertEquals(expectedUnSuccessfulMessage, byteArrayOutputStream.toString());
    }

    @Test
    void shouldBeAbleToGetASuccessMessageIfBookIsReturned() {
        ByteArrayOutputStream byteArrayOutputStream = initializeOutputStream();
        Book book = mock(Book.class);
        BookList bookList = new BookList();
        String expectedUnSuccessfulMessage = "Thank you for returning the book";
        bookList.add(book.getTitle());

        bookList.returnBook(book.getTitle());

        assertEquals(expectedUnSuccessfulMessage, byteArrayOutputStream.toString());
    }

}