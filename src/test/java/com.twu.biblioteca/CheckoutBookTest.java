package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

class CheckoutBookTest {
    User user = mock(User.class);

    @Test
    void shouldNotAllowCheckoutIfUserIsNotValidated() throws IOException {
        BookList bookList = mock(BookList.class);
        Validator validator = mock(Validator.class);
        when(validator.isValid()).thenReturn(false);
        CheckoutBook checkoutBook = new CheckoutBook(bookList, validator, user);

        checkoutBook.execute();

        verify(bookList, times(0)).checkout(user);
    }

    @Test
    void shouldAllowCheckoutIfUserIsNotValidated() throws IOException {
        BookList bookList = mock(BookList.class);
        Validator validator = mock(Validator.class);
        when(validator.isValid()).thenReturn(true);
        CheckoutBook checkoutBook = new CheckoutBook(bookList, validator, user);

        checkoutBook.execute();

        verify(bookList, times(1)).checkout(user);
    }
}