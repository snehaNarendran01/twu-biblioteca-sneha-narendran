package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

class BookListTest {

    private UserOutput userOutput = mock(UserOutput.class);
    private User user = mock(User.class);

    @Test
    void shouldBeAbleToCheckoutBookIfItExistInList() throws IOException {
        UserInput userInput = mock(UserInput.class);
        when(userInput.scanBookTitle()).thenReturn("Harry Potter");
        BookList bookList = new BookList(userInput, userOutput, user);
        try {
            bookList.checkout("Harry Potter");
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void shouldBeAbleToGetAnUnsuccessfulMessageIfBookIfItDoesNotExistInList() throws IOException {
        UserInput userInput = mock(UserInput.class);
        BookList bookList = new BookList(userInput, userOutput, user);

        String expectedUnSuccessfulMessage = "Sorry, that book is not available\n";

        bookList.checkout("Famous Fie");

        verify(userOutput, times(1)).print(expectedUnSuccessfulMessage);
    }

    @Test
    void shouldBeAbleToGetASuccessMessageIfTheBookWasRemovedSuccessfully() throws IOException {
        UserInput userInput = mock(UserInput.class);
        BookList bookList = new BookList(userInput, userOutput, user);
        String expectedSuccessMessage = "Thank you! Enjoy the book\n";

        bookList.checkout("Harry Potter");

        verify(userOutput, times(1)).print(expectedSuccessMessage);
    }

    @Test
    void shouldBeAbleToGetAnUnsuccessfulMessageIfBookCouldNotBeReturned() throws IOException {
        UserInput userInput = mock(UserInput.class);
        BookList bookList = new BookList(userInput, userOutput, user);
        when(userInput.scanBookTitle()).thenReturn("Harry Poter");
        String expectedUnSuccessfulMessage = "That is not a valid book to return.\n";

        bookList.returnBook();

        verify(userOutput, times(1)).print(expectedUnSuccessfulMessage);
    }

    @Test
    void shouldBeAbleToGetASuccessMessageIfBookIsReturned() throws IOException {
        UserInput userInput = mock(UserInput.class);
        BookList bookList = new BookList(userInput, userOutput, user);
        when(userInput.scanBookTitle()).thenReturn("Harry Potter");
        String expectedSuccessfulMessageForCheckout = "Thank you! Enjoy the book\n";
        String expectedSuccessfulMessageForReturn = "Thank you for returning the book\n";
        bookList.checkout("Harry Potter");

        bookList.returnBook();

        verify(userOutput, times(1)).print(expectedSuccessfulMessageForCheckout);
        verify(userOutput, times(1)).print(expectedSuccessfulMessageForReturn);
    }

    @Test
    void shouldOnlyBeAbleToReturnCheckedOutBooks() throws IOException {
        UserInput userInput = mock(UserInput.class);
        BookList bookList = new BookList(userInput, userOutput, user);
        when(userInput.scanBookTitle()).thenReturn("Harry Potter");
        String expectedSuccessfulMessageForCheckedOutBooks = "Thank you! Enjoy the book\n";
        String expectedSuccessfulMessageForReturn = "Thank you for returning the book\n";

        bookList.checkout("Harry Potter");
        bookList.returnBook();

        verify(userOutput, times(1)).print(expectedSuccessfulMessageForCheckedOutBooks);
        verify(userOutput, times(1)).print(expectedSuccessfulMessageForReturn);
    }

    @Test
    void shouldBeAbleToCheckoutAReturnedBook() throws IOException {
        UserInput userInput = mock(UserInput.class);
        BookList bookList = new BookList(userInput, userOutput, user);
        when(userInput.scanBookTitle()).thenReturn("Harry Potter");
        String expectedSuccessfulMessageForCheckedOutBooks = "Thank you! Enjoy the book\n";
        String expectedSuccessfulMessageForReturn = "Thank you for returning the book\n";
        bookList.checkout("Harry Potter");
        bookList.returnBook();

        bookList.checkout("Harry Potter");

        verify(userOutput, times(2)).print(expectedSuccessfulMessageForCheckedOutBooks);
        verify(userOutput, times(1)).print(expectedSuccessfulMessageForReturn);
    }
}

