package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;

class BookInventoryTest {
    @Test
    void shouldBeAbleToCheckoutBookIfItExistInInventory() {
        Book book = mock(Book.class);
        BookInventory bookInventory = new BookInventory();
        try {
            bookInventory.remove(book);
        } catch (Exception e) {
            fail();
        }
    }
}