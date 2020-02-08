package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;

class BookInventoryTest {
    @Test
    void shouldBeAbleToCheckoutBookIfItExistInInventory() {
        Book book = mock(Book.class);
        BookInventory bookInventory = new BookInventory(new ArrayList<>(Collections.singletonList(book)));
        try {
            bookInventory.remove(book);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void shouldNotAbleToCheckoutBookIfItDoesNotExistInInventory() {
        Book book = mock(Book.class);
        BookInventory bookInventory = new BookInventory(new ArrayList<>());
        assertThrows(BookNotFoundException.class, () -> bookInventory.remove(book));
    }
}