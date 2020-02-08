package com.twu.biblioteca;

import com.twu.biblioteca.exception.BookAlreadyExistException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class BookInventoryTest {
    @Test
    void shouldBeAbleToAddBookInInventory() {
        Book book = mock(Book.class);
        BookInventory bookInventory = new BookInventory(new ArrayList<>());
        try {
            bookInventory.addBook(book);
        } catch (Exception e) {
            fail("Not able to add a book");
        }
    }

    @Test
    void shouldNotBeAbleToAddBookTwice() {
        Book book = mock(Book.class);
        BookInventory bookInventory = new BookInventory(new ArrayList<>(Collections.singletonList(book)));

        assertThrows(BookAlreadyExistException.class, () -> bookInventory.addBook(book));
    }

    @Test
    void shouldBeAbleToCheckoutBookIfItExistInInventory() {
        Book book = mock(Book.class);
        BookInventory bookInventory = new BookInventory(new ArrayList<>());
        try {
            bookInventory.addBook(book);
            bookInventory.removeBook(book);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void shouldBeAbleToGetAnUnsuccessfulMessageIfBookIfItDoesNotExistInInventory() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Book book = mock(Book.class);
        BookInventory bookInventory = new BookInventory(new ArrayList<>());
        String expectedUnSuccessfullMessage = "Sorry, that book is not available";

        bookInventory.removeBook(book);

        assertEquals(expectedUnSuccessfullMessage, byteArrayOutputStream.toString());

    }

    @Test
    void shouldBeAbleToGetASuccessMessageIfTheBookWasRemovedSuccessfully() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Book book = mock(Book.class);
        BookInventory bookInventory = new BookInventory(new ArrayList<>(Collections.singletonList(book)));
        String expectedSuccessMessage = "Thank you! Enjoy the book";

        bookInventory.removeBook(book);

        assertEquals(expectedSuccessMessage, byteArrayOutputStream.toString());
    }

    @Test
    void shouldBeAbleToGetASuccessMessageIfTheBookWasReturnedSuccessfully() throws BookAlreadyExistException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Book book = mock(Book.class);
        BookInventory bookInventory = new BookInventory(new ArrayList<>());
        String expectedSuccessMessage = "Thank you for returning the book";

        bookInventory.addBook(book);

        assertEquals(expectedSuccessMessage, byteArrayOutputStream.toString());
    }
}