package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;

class BookInventoryTest {
    @Test
    void shouldBeAbleToAddBookInInventory() {
        Book book = mock(Book.class);
        BookInventory bookInventory = new BookInventory();
        try {
            bookInventory.add(book);
        } catch (Exception e) {
            fail("Not able to add a book");
        }
    }

    @Test
    void shouldBeAbleToCheckoutBookIfItExistInInventory() {
        Book book = mock(Book.class);
        BookInventory bookInventory = new BookInventory();
        try {
            bookInventory.add(book);
            bookInventory.remove(book);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void shouldBeAbleToGetAnUnsuccessfulMessageIfBookIfItDoesNotExistInInventory() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Book book = mock(Book.class);
        BookInventory bookInventory = new BookInventory();
        String expectedUnSuccessfulMessage = "Sorry, that book is not available";

        bookInventory.remove(book);

        assertEquals(expectedUnSuccessfulMessage, byteArrayOutputStream.toString());
    }

    @Test
    void shouldBeAbleToGetASuccessMessageIfTheBookWasRemovedSuccessfully() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Book book = mock(Book.class);
        BookInventory bookInventory = new BookInventory();
        String expectedSuccessMessage = "Thank you! Enjoy the book";

        bookInventory.add(book);
        bookInventory.remove(book);

        assertEquals(expectedSuccessMessage, byteArrayOutputStream.toString());
    }

    @Test
    void shouldBeAbleToGetAnUnsuccessfulMessageIfBookCouldNotBeAdded() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Book book = mock(Book.class);
        BookInventory bookInventory = new BookInventory();
        String expectedUnSuccessfulMessage = "That is not a valid book to return.";

        bookInventory.returnBook(book);

        assertEquals(expectedUnSuccessfulMessage, byteArrayOutputStream.toString());
    }

    @Test
    void shouldBeAbleToGetASuccessMessageIfBookIsReturned() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Book book = mock(Book.class);
        BookInventory bookInventory = new BookInventory();
        String expectedUnSuccessfulMessage = "Thank you for returning the book";
        bookInventory.add(book);

        bookInventory.returnBook(book);

        assertEquals(expectedUnSuccessfulMessage, byteArrayOutputStream.toString());
    }
}