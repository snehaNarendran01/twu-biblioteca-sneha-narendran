package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
    void shouldBeAbleToViewTheListOfBooksFromTheMenuIfChoosesOptionOne() throws IOException {
        UserInput userInput = mock(UserInput.class);
        BookViewer bookViewer = mock(BookViewer.class);
        Menu menu = new Menu(bookViewer, null, userInput);
        when(userInput.scanOption()).thenReturn(1);

        menu.showMenu();

        verify(bookViewer, times(1)).printBookDetails();
    }

    @Test
    void shouldNotBeAbleToViewTheListOfBooksFromTheMenuIfChosenOptionIsNotOne() throws IOException {
        UserInput userInput = mock(UserInput.class);
        BookViewer bookViewer = mock(BookViewer.class);
        Menu menu = new Menu(bookViewer, null, userInput);
        when(userInput.scanOption()).thenReturn(8);

        menu.showMenu();

        verify(bookViewer, times(0)).printBookDetails();
    }

    @Test
    void shouldShowInvalidOptionMessageIfChosenOptionIsIncorrect() throws IOException {
        UserInput userInput = mock(UserInput.class);
        when(userInput.scanOption()).thenReturn(8);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        BookViewer bookViewer = mock(BookViewer.class);
        Menu menu = new Menu(bookViewer, null, userInput);
        String expectedErrorMessage = "Please select a valid option!";

        menu.showMenu();

        assertEquals(expectedErrorMessage, byteArrayOutputStream.toString());
    }

    @Test
    void shouldBeAbleToCheckoutABookIfChosenOptionTwo() throws IOException {
        UserInput userInput = mock(UserInput.class);
        when(userInput.scanOption()).thenReturn(2);
        BookViewer bookViewer = mock(BookViewer.class);
        BookList bookList = mock(BookList.class);
        Menu menu = new Menu(bookViewer, bookList, userInput);

        menu.showMenu();

        verify(bookList, times(1)).checkout(null);
    }

    @Test
    void shouldBeAbleToReturnBookIfChosenOptionIsThree() throws IOException {
        UserInput userInput = mock(UserInput.class);
        when(userInput.scanOption()).thenReturn(3);
        BookViewer bookViewer = mock(BookViewer.class);
        BookList bookList = mock(BookList.class);
        Menu menu = new Menu(bookViewer, bookList, userInput);

        menu.showMenu();

        verify(bookList, times(1)).returnBook();
    }

    @Test
    void shouldDisplayTheMenuBeforeUserInputIsTaken() {
        UserInput userInput = mock(UserInput.class);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Menu menu = new Menu(null, null, userInput);
        String expectedString = "\nSelect any one of the options: \n1: Listing all books\n2: " +
                "Checkout a specified book\n3: Return a book\n4: Quit the application\n";

        menu.displayMenu();

        assertEquals(expectedString, byteArrayOutputStream.toString());
    }

    @Disabled
    @Test
    void shouldQuitTheApplicationIfOptionFourIsSelected() throws IOException {
        UserInput userInput = mock(UserInput.class);
        when(userInput.scanOption()).thenReturn(4);
        BookViewer bookViewer = mock(BookViewer.class);
        BookList bookList = mock(BookList.class);
        Menu menu = new Menu(bookViewer, bookList, userInput);

        menu.showMenu();
    }

}