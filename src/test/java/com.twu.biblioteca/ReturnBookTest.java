package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ReturnBookTest {
    @Test
    void shouldThrowInvalidOptionExceptionIfTriedToViewDetailsBeforeLogin() throws IOException {
        ReturnBook returnBook = new ReturnBook(mock(BookList.class), mock(User.class));
        Validator validator = mock(Validator.class);
        when(validator.isValid()).thenReturn(true);

        Assertions.assertThrows(InvalidOptionException.class, returnBook::getOptionBeforeLogin);
    }

}