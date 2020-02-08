package com.twu.biblioteca;

import com.twu.biblioteca.exception.BookAlreadyExistException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MenuTest {

    @Test
    void shouldBeAbleToViewTheListOfBooksFromTheMenuIfChoosesOptionOne() throws BookAlreadyExistException {
        BookViewer bookViewer = mock(BookViewer.class);
        Menu menu = new Menu(bookViewer, null);

        menu.showMenu(1, mock(Book.class));

        verify(bookViewer, times(1)).printBookDetails();
    }

    @Test
    void shouldNotBeAbleToViewTheListOfBooksFromTheMenuIfChosenOptionIsNotOne() throws BookAlreadyExistException {
        BookViewer bookViewer = mock(BookViewer.class);
        Menu menu = new Menu(bookViewer, null);

        menu.showMenu(8, mock(Book.class));

        verify(bookViewer, times(0)).printBookDetails();
    }

    @Test
    void shouldShowInvalidOptionMessageIfChosenOptionIsIncorrect() throws BookAlreadyExistException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        BookViewer bookViewer = mock(BookViewer.class);
        Menu menu = new Menu(bookViewer, null);
        String expectedErrorMessage = "Please select a valid option!";

        menu.showMenu(8, mock(Book.class));

        assertEquals(expectedErrorMessage, byteArrayOutputStream.toString());
    }

    @Test
    void shouldBeAbleToCheckoutABookIfChosenOptionTwo() throws BookAlreadyExistException {
        BookViewer bookViewer = mock(BookViewer.class);
        BookInventory bookInventory = mock(BookInventory.class);
        Menu menu = new Menu(bookViewer, bookInventory);

        Book book = mock(Book.class);
        menu.showMenu(2, book);

        verify(bookInventory, times(1)).removeBook(book);
    }

    @Test
    void shouldBeAbleToReturnBookIfChosenOptionIsThree() throws BookAlreadyExistException {
        BookViewer bookViewer = mock(BookViewer.class);
        BookInventory bookInventory = mock(BookInventory.class);
        Menu menu = new Menu(bookViewer, bookInventory);

        Book book = mock(Book.class);
        menu.showMenu(3, book);

        verify(bookInventory, times(1)).addBook(book);
    }
}