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

        menu.showMenu(1);

        verify(bookViewer, times(1)).printBookDetails();
    }

    @Test
    void shouldNotBeAbleToViewTheListOfBooksFromTheMenuIfChosenOptionIsNotOne() {
        BookViewer bookViewer = mock(BookViewer.class);
        Menu menu = new Menu(bookViewer, null);

        menu.showMenu(8);

        verify(bookViewer, times(0)).printBookDetails();
    }

    @Test
    void shouldShowInvalidOptionMessageIfChosenOptionIsIncorrect() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        BookViewer bookViewer = mock(BookViewer.class);
        Menu menu = new Menu(bookViewer, null);
        String expectedErrorMessage = "Please select a valid option!";

        menu.showMenu(8);

        assertEquals(expectedErrorMessage, byteArrayOutputStream.toString());
    }

    @Test
    void shouldBeAbleToCheckoutABookIfChosenOptionTwo() {
        BookViewer bookViewer = mock(BookViewer.class);
        BookList bookList = mock(BookList.class);
        Menu menu = new Menu(bookViewer, bookList);

        menu.showMenu(2);

        verify(bookList, times(1)).checkout("");
    }

    @Test
    void shouldBeAbleToReturnBookIfChosenOptionIsThree() {
        BookViewer bookViewer = mock(BookViewer.class);
        BookList bookList = mock(BookList.class);
        Menu menu = new Menu(bookViewer, bookList);

        menu.showMenu(3);

        verify(bookList, times(1)).returnBook("");
    }

    @Test
    void shouldDisplayTheMenuBeforeUserInputIsTaken() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Menu menu = new Menu(null, null);
        String expectedString = "\nSelect any one of the options: \n1: Listing all books\n2: Checkout a specified book\n3: Return a book\n4: Quit the application";

        menu.displayMenu();

        assertEquals(expectedString, byteArrayOutputStream.toString());
    }

    @Test
    void shouldQuitTheApplicationIfOptionFourIsSelected() {
        BookViewer bookViewer = mock(BookViewer.class);
        BookList bookList = mock(BookList.class);
        Menu menu = new Menu(bookViewer, bookList);

        menu.showMenu(4);
    }
}