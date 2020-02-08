package com.twu.biblioteca;

import com.twu.biblioteca.exception.BookAlreadyExistException;
import com.twu.biblioteca.exception.BookNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
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
    void shouldNotAbleToCheckoutBookIfItDoesNotExistInInventory() {
        Book book = mock(Book.class);
        BookInventory bookInventory = new BookInventory(new ArrayList<>());

        assertThrows(BookNotFoundException.class, () -> bookInventory.removeBook(book));
    }

    @Test
    void shouldNotBeAbleToRemoveABookTwice() throws BookNotFoundException {
        Book book = mock(Book.class);
        BookInventory bookInventory = new BookInventory(new ArrayList<>(Collections.singletonList(book)));
        bookInventory.removeBook(book);
        assertThrows(BookNotFoundException.class, () -> bookInventory.removeBook(book));
    }
}