package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookListTest {

    private ByteArrayOutputStream byteArrayOutputStream;

    private void initializeOutputStream() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    void shouldBeAbleToCheckoutBookIfItExistInList() throws IOException {
        UserInput userInput = mock(UserInput.class);
        when(userInput.scanBookTitle()).thenReturn("Harry Potter");
        BookList bookList = new BookList(userInput);
        try {
            bookList.checkout("Harry Potter");
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void shouldBeAbleToGetAnUnsuccessfulMessageIfBookIfItDoesNotExistInList() {
        UserInput userInput = mock(UserInput.class);
        initializeOutputStream();
        BookList bookList = new BookList(userInput);

        String expectedUnSuccessfulMessage = "Sorry, that book is not available";

        bookList.checkout("Famous Fie");

        assertEquals(expectedUnSuccessfulMessage, byteArrayOutputStream.toString());
    }

    @Test
    void shouldBeAbleToGetASuccessMessageIfTheBookWasRemovedSuccessfully() {
        initializeOutputStream();
        UserInput userInput = mock(UserInput.class);
        BookList bookList = new BookList(userInput);
        String expectedSuccessMessage = "Thank you! Enjoy the book";

        bookList.checkout("Harry Potter");

        assertEquals(expectedSuccessMessage, byteArrayOutputStream.toString());
    }

    @Test
    void shouldBeAbleToGetAnUnsuccessfulMessageIfBookCouldNotBeReturned() throws IOException {
        initializeOutputStream();
        UserInput userInput = mock(UserInput.class);
        BookList bookList = new BookList(userInput);
        when(userInput.scanBookTitle()).thenReturn("Harry Poter");
        String expectedUnSuccessfulMessage = "That is not a valid book to return.";

        bookList.returnBook();

        assertEquals(expectedUnSuccessfulMessage, byteArrayOutputStream.toString());
    }

    @Test
    void shouldBeAbleToGetASuccessMessageIfBookIsReturned() throws IOException {
        initializeOutputStream();
        UserInput userInput = mock(UserInput.class);
        BookList bookList = new BookList(userInput);
        when(userInput.scanBookTitle()).thenReturn("Harry Potter");
        String expectedUnSuccessfulMessage = "Thank you! Enjoy the bookThank you for returning the book";
        bookList.checkout("Harry Potter");

        bookList.returnBook();

        assertEquals(expectedUnSuccessfulMessage, byteArrayOutputStream.toString());
    }

    @Test
    void shouldOnlyBeAbleToReturnCheckedOutBooks() throws IOException {
        initializeOutputStream();
        UserInput userInput = mock(UserInput.class);
        BookList bookList = new BookList(userInput);
        when(userInput.scanBookTitle()).thenReturn("Harry Potter");
        String expectedUnSuccessfulMessage = "Thank you! Enjoy the bookThank you for returning the book";

        bookList.checkout("Harry Potter");
        bookList.returnBook();

        assertEquals(expectedUnSuccessfulMessage, byteArrayOutputStream.toString());
    }

    @Test
    void shouldBeAbleToCheckoutAReturnedBook() throws IOException {
        initializeOutputStream();
        UserInput userInput = mock(UserInput.class);
        BookList bookList = new BookList(userInput);
        when(userInput.scanBookTitle()).thenReturn("Harry Potter");
        String expectedUnSuccessfulMessage = "Thank you! Enjoy the bookThank you for returning the bookThank you! Enjoy the book";
        bookList.checkout("Harry Potter");
        bookList.returnBook();

        bookList.checkout("Harry Potter");

        assertEquals(expectedUnSuccessfulMessage, byteArrayOutputStream.toString());

    }

}