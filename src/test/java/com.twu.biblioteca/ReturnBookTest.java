package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

class ReturnBookTest {
    User user = mock(User.class);
    @Test
    void shouldAllowReturnWhenUserCredentialsAreCorrect() throws IOException {
        BookList bookList=mock(BookList.class);
        Validator validator=mock(Validator.class);
        when(validator.isValid()).thenReturn(true);
        ReturnBook returnBook = new ReturnBook(bookList, validator, user);

        returnBook.execute();

        verify(bookList, times(1)).returnBook(user);
    }

    @Test
    void shouldNotAllowReturnWhenUserCredentialsAreIncorrect() throws IOException {
        BookList bookList=mock(BookList.class);
        Validator validator=mock(Validator.class);
        when(validator.isValid()).thenReturn(false);
        ReturnBook returnBook = new ReturnBook(bookList, validator, user);

        returnBook.execute();

        verify(bookList, times(0)).returnBook(user);
    }
}