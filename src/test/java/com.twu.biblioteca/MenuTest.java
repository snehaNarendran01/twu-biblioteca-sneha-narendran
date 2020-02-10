package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MenuTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void reset() {
        System.setOut(System.out);
    }

    @Test
    void shouldBeAbleToViewTheListOfBooksFromTheMenuIfChoosesOptionOne() {
        String input = "1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BookViewer bookViewer = mock(BookViewer.class);
        Menu menu = new Menu(bookViewer, null);

        menu.showMenu();

        verify(bookViewer, times(1)).printBookDetails();
    }

    @Test
    void shouldNotBeAbleToViewTheListOfBooksFromTheMenuIfChosenOptionIsNotOne() {
        String input = "8";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BookViewer bookViewer = mock(BookViewer.class);
        Menu menu = new Menu(bookViewer, null);

        menu.showMenu();

        verify(bookViewer, times(0)).printBookDetails();
    }

    @Test
    void shouldShowInvalidOptionMessageIfChosenOptionIsIncorrect() {
        String input = "8";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        BookViewer bookViewer = mock(BookViewer.class);
        Menu menu = new Menu(bookViewer, null);
        String expectedErrorMessage = "Please select a valid option!";

        menu.showMenu();

        assertEquals(expectedErrorMessage, byteArrayOutputStream.toString());
    }

    @Test
    void shouldBeAbleToCheckoutABookIfChosenOptionTwo() {
        String input = "2";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BookViewer bookViewer = mock(BookViewer.class);
        BookList bookList = mock(BookList.class);
        Menu menu = new Menu(bookViewer, bookList);

        menu.showMenu();

        verify(bookList, times(1)).checkout();
    }

    @Test
    void shouldBeAbleToReturnBookIfChosenOptionIsThree() {
        String input = "3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BookViewer bookViewer = mock(BookViewer.class);
        BookList bookList = mock(BookList.class);
        Menu menu = new Menu(bookViewer, bookList);

        menu.showMenu();

        verify(bookList, times(1)).returnBook();
    }

    @Test
    void shouldDisplayTheMenuBeforeUserInputIsTaken() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Menu menu = new Menu(null, null);
        String expectedString = "\nSelect any one of the options: \n1: Listing all books\n2: " +
                "Checkout a specified book\n3: Return a book\n4: Quit the application";

        menu.displayMenu();

        assertEquals(expectedString, byteArrayOutputStream.toString());
    }

    @Disabled
    @Test
    void shouldQuitTheApplicationIfOptionFourIsSelected() {
        String input = "4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BookViewer bookViewer = mock(BookViewer.class);
        BookList bookList = mock(BookList.class);
        Menu menu = new Menu(bookViewer, bookList);

        menu.showMenu();
    }

}