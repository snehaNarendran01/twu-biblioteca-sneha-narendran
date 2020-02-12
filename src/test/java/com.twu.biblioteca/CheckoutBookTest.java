package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

class CheckoutBookTest {
    @Test
    void shouldNotAllowCheckoutIfUserIsNotValidated() throws IOException {
        BookList bookList = mock(BookList.class);
        UserInput userInput = mock(UserInput.class);
        UserOutput userOutput = mock(UserOutput.class);
        Validator validator = mock(Validator.class);
        when(validator.isValid()).thenReturn(false);
        CheckoutBook checkoutBook = new CheckoutBook(bookList, userInput, userOutput, validator);

        checkoutBook.execute();

        verify(bookList, times(0)).checkout(null);
    }
}