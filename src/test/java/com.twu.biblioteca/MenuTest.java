package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MenuTest {

    @Test
    void shouldBeAbleToViewTheListOfBooksFromTheMenuIfChoosesOptionOne() {
        BookViewer bookViewer = mock(BookViewer.class);
        Menu menu = new Menu(bookViewer, null);

        menu.showMenu(1, mock(Book.class).getTitle());

        verify(bookViewer, times(1)).printBookDetails();
    }

    @Test
    void shouldNotBeAbleToViewTheListOfBooksFromTheMenuIfChosenOptionIsNotOne() {
        BookViewer bookViewer = mock(BookViewer.class);
        Menu menu = new Menu(bookViewer, null);

        menu.showMenu(8, mock(Book.class).getTitle());

        verify(bookViewer, times(0)).printBookDetails();
    }

    @Test
    void shouldShowInvalidOptionMessageIfChosenOptionIsIncorrect() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        BookViewer bookViewer = mock(BookViewer.class);
        Menu menu = new Menu(bookViewer, null);
        String expectedErrorMessage = "Please select a valid option!";

        menu.showMenu(8, mock(Book.class).getTitle());

        assertEquals(expectedErrorMessage, byteArrayOutputStream.toString());
    }

    @Test
    void shouldBeAbleToCheckoutABookIfChosenOptionTwo() {
        BookViewer bookViewer = mock(BookViewer.class);
        BookList bookList = mock(BookList.class);
        Menu menu = new Menu(bookViewer, bookList);

        Book book = mock(Book.class);
        menu.showMenu(2, book.getTitle());

        verify(bookList, times(1)).checkout(book.getTitle());
    }

    @Test
    void shouldBeAbleToReturnBookIfChosenOptionIsThree() {
        BookViewer bookViewer = mock(BookViewer.class);
        BookList bookList = mock(BookList.class);
        Menu menu = new Menu(bookViewer, bookList);

        Book book = mock(Book.class);
        menu.showMenu(3, book.getTitle());

        verify(bookList, times(1)).returnBook(book.getTitle());
    }

    @Test
    void shouldDisplayTheMenuBeforeUserInputIsTaken() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Menu menu = new Menu(null, null);
        String expectedString = "Select any one of the options: \n1: Listing all books\n2: Checkout a specified book\n3: Return a book\n4: Quit the application";

        menu.displayMenu();

        assertEquals(expectedString, byteArrayOutputStream.toString());
    }
}