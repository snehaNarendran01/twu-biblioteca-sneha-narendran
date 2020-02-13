package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

class BookListTest {
    private UserOutput userOutput = mock(UserOutput.class);
    User user = mock(User.class);
    private UserInput userInput = mock(UserInput.class);

    @Test
    void shouldBeAbleToCheckoutBookIfItExistInList() throws IOException {
        UserInput userInput = mock(UserInput.class);
        when(userInput.scanBookTitle()).thenReturn("Harry Potter");
        BookList bookList = new BookList(userInput, userOutput);
        try {
            bookList.checkout(user);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void shouldBeAbleToGetAnUnsuccessfulMessageIfBookIfItDoesNotExistInList() throws IOException {
        BookList bookList = new BookList(userInput, userOutput);
        when(userInput.scanBookTitle()).thenReturn("Famous Fie");
        String expectedUnSuccessfulMessage = "Sorry, that book is not available\n";

        bookList.checkout(user);

        verify(userOutput, times(1)).print(expectedUnSuccessfulMessage);
    }

    @Test
    void shouldBeAbleToGetASuccessMessageIfTheBookWasRemovedSuccessfully() throws IOException {
        when(userInput.scanBookTitle()).thenReturn("Harry Potter");
        BookList bookList = new BookList(userInput, userOutput);
        String expectedSuccessMessage = "Thank you! Enjoy the book\n";

        bookList.checkout(user);

        verify(userOutput, times(1)).print(expectedSuccessMessage);
    }

    @Test
    void shouldBeAbleToGetAnUnsuccessfulMessageIfBookCouldNotBeReturned() throws IOException {
        BookList bookList = new BookList(userInput, userOutput);
        when(userInput.scanBookTitle()).thenReturn("Harry Poter");
        String expectedUnSuccessfulMessage = "That is not a valid book to return.\n";

        bookList.returnBook(user);

        verify(userOutput, times(1)).print(expectedUnSuccessfulMessage);
    }

    @Test
    void shouldBeAbleToGetASuccessMessageIfBookIsReturned() throws IOException {
        UserInput userInput = mock(UserInput.class);
        BookList bookList = new BookList(userInput, userOutput);
        when(userInput.scanBookTitle()).thenReturn("Harry Potter");
        String expectedSuccessfulMessageForCheckout = "Thank you! Enjoy the book\n";
        String expectedSuccessfulMessageForReturn = "Thank you for returning the book\n";
        bookList.checkout(user);

        bookList.returnBook(user);

        verify(userOutput, times(1)).print(expectedSuccessfulMessageForCheckout);
        verify(userOutput, times(1)).print(expectedSuccessfulMessageForReturn);
    }

    @Test
    void shouldOnlyBeAbleToReturnCheckedOutBooks() throws IOException {
        BookList bookList = new BookList(userInput, userOutput);
        when(userInput.scanBookTitle()).thenReturn("Harry Potter");
        String expectedSuccessfulMessageForCheckedOutBooks = "Thank you! Enjoy the book\n";
        String expectedSuccessfulMessageForReturn = "Thank you for returning the book\n";

        bookList.checkout(user);
        bookList.returnBook(user);

        verify(userOutput, times(1)).print(expectedSuccessfulMessageForCheckedOutBooks);
        verify(userOutput, times(1)).print(expectedSuccessfulMessageForReturn);
    }

    @Test
    void shouldBeAbleToCheckoutAReturnedBook() throws IOException {
        BookList bookList = new BookList(userInput, userOutput);
        when(userInput.scanBookTitle()).thenReturn("Harry Potter");
        String expectedSuccessfulMessageForCheckedOutBooks = "Thank you! Enjoy the book\n";
        String expectedSuccessfulMessageForReturn = "Thank you for returning the book\n";
        bookList.checkout(user);
        bookList.returnBook(user);

        bookList.checkout(user);

        verify(userOutput, times(2)).print(expectedSuccessfulMessageForCheckedOutBooks);
        verify(userOutput, times(1)).print(expectedSuccessfulMessageForReturn);
    }

    @Test
    void shouldReturnUserWhoCheckedOutAParticularBook() throws IOException {
        BookList bookList = new BookList(userInput, userOutput);
        when(userInput.scanBookTitle()).thenReturn("Harry Potter");
        bookList.checkout(user);

        Assertions.assertEquals(user, bookList.issuedBy());
    }

    @Test
    void shouldReturnNullWhenABookIsCheckoutByNoOne() throws IOException {
        BookList bookList = new BookList(userInput, userOutput);
        when(userInput.scanBookTitle()).thenReturn("");
        bookList.checkout(user);

        Assertions.assertNull(bookList.issuedBy());
    }
}

