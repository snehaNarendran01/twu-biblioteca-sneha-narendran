package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

class MenuTest {

    @Test
    void shouldBeAbleToViewTheListOfBooksFromTheMenuIfChoosesOptionOne() throws IOException {
        UserInput userInput = mock(UserInput.class);
        UserOutput userOutput = mock(UserOutput.class);
        ApplicationQuitter applicationQuitter = mock(ApplicationQuitter.class);
        BookViewer bookViewer = mock(BookViewer.class);
        Menu menu = new Menu(bookViewer, null, userInput, userOutput, applicationQuitter);
        when(userInput.scanOption()).thenReturn(1, 4);

        menu.showMenu();

        verify(bookViewer, times(1)).printBookDetails();
    }

    @Test
    void shouldNotBeAbleToViewTheListOfBooksFromTheMenuIfChosenOptionIsNotOne() throws IOException {
        UserInput userInput = mock(UserInput.class);
        ApplicationQuitter applicationQuitter = mock(ApplicationQuitter.class);
        UserOutput userOutput = mock(UserOutput.class);
        BookViewer bookViewer = mock(BookViewer.class);
        Menu menu = new Menu(bookViewer, null, userInput, userOutput, applicationQuitter);
        when(userInput.scanOption()).thenReturn(8, 4);

        menu.showMenu();

        verify(bookViewer, times(0)).printBookDetails();
    }

    @Test
    void shouldShowInvalidOptionMessageIfChosenOptionIsIncorrect() throws IOException {
        UserInput userInput = mock(UserInput.class);
        ApplicationQuitter applicationQuitter = mock(ApplicationQuitter.class);
        UserOutput userOutput = mock(UserOutput.class);
        when(userInput.scanOption()).thenReturn(8, 4);
        BookViewer bookViewer = mock(BookViewer.class);
        Menu menu = new Menu(bookViewer, null, userInput, userOutput, applicationQuitter);

        menu.showMenu();

        verify(userOutput, times(1)).displayInvalidOptionMessage();
    }

    @Test
    void shouldBeAbleToCheckoutABookIfChosenOptionTwo() throws IOException {
        UserInput userInput = mock(UserInput.class);
        ApplicationQuitter applicationQuitter = mock(ApplicationQuitter.class);
        UserOutput userOutput = mock(UserOutput.class);

        when(userInput.scanOption()).thenReturn(2, 4);
        BookViewer bookViewer = mock(BookViewer.class);
        BookList bookList = mock(BookList.class);
        Menu menu = new Menu(bookViewer, bookList, userInput, userOutput, applicationQuitter);

        menu.showMenu();

        verify(bookList, times(1)).checkout(null);
    }

    @Test
    void shouldBeAbleToReturnBookIfChosenOptionIsThree() throws IOException {
        UserInput userInput = mock(UserInput.class);
        UserOutput userOutput = mock(UserOutput.class);
        ApplicationQuitter applicationQuitter = mock(ApplicationQuitter.class);

        when(userInput.scanOption()).thenReturn(3, 4);
        BookViewer bookViewer = mock(BookViewer.class);
        BookList bookList = mock(BookList.class);
        Menu menu = new Menu(bookViewer, bookList, userInput, userOutput, applicationQuitter);

        menu.showMenu();

        verify(bookList, times(1)).returnBook();
    }

    @Test
    void shouldDisplayTheMenuBeforeUserInputIsTaken() {
        UserInput userInput = mock(UserInput.class);
        UserOutput userOutput = mock(UserOutput.class);
        ApplicationQuitter applicationQuitter = mock(ApplicationQuitter.class);

        Menu menu = new Menu(null, null, userInput, userOutput, applicationQuitter);

        menu.displayMenu();

        verify(userOutput, times(1)).showMenu();
    }

    @Test
    void shouldQuitTheApplicationIfOptionFourIsSelected() throws IOException {
        ApplicationQuitter applicationQuitter = mock(ApplicationQuitter.class);
        UserInput userInput = mock(UserInput.class);
        UserOutput userOutput = mock(UserOutput.class);

        when(userInput.scanOption()).thenReturn(4);
        BookViewer bookViewer = mock(BookViewer.class);
        BookList bookList = mock(BookList.class);
        Menu menu = new Menu(bookViewer, bookList, userInput, userOutput, applicationQuitter);

        menu.showMenu();
    }

    @Test
    void shouldNotQitTheApplicationUntilOptionFourIsSelected() throws IOException {
        UserInput userInput = mock(UserInput.class);
        ApplicationQuitter applicationQuitter = mock(ApplicationQuitter.class);
        UserOutput userOutput = mock(UserOutput.class);

        when(userInput.scanOption()).thenReturn(1, 4, 2);
        BookViewer bookViewer = mock(BookViewer.class);
        BookList bookList = mock(BookList.class);
        Menu menu = new Menu(bookViewer, bookList, userInput, userOutput, applicationQuitter);

        menu.showMenu();

        verify(bookViewer, times(1)).printBookDetails();
        verify(bookList, times(0)).checkout("Harry Potter");
    }
}