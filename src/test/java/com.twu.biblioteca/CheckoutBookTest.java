package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CheckoutBookTest {
    @Test
    void shouldThrowInvalidOptionExceptionIfTriedToViewDetailsBeforeLogin() throws IOException {
        BookList bookList = mock(BookList.class);
        User user = mock(User.class);
        CheckoutBook checkoutBook = new CheckoutBook(bookList, user);
        Validator validator = mock(Validator.class);
        when(validator.isValid()).thenReturn(true);

        Assertions.assertThrows(InvalidOptionException.class, checkoutBook::getOptionBeforeLogin);
    }

}