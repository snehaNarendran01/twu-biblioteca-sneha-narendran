package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

class MenuTest {
    Validator validator;
    UserInput userInput;
    UserOutput userOutput;
    BookViewer bookViewer;
    ApplicationQuitter applicationQuitter;
    MovieViewer movieViewer;
    MovieList movieList;
    BookList bookList;
    User user;

    void initialize() {
        validator = mock(Validator.class);
        userInput = mock(UserInput.class);
        userOutput = mock(UserOutput.class);
        bookViewer = mock(BookViewer.class);
        applicationQuitter = mock(ApplicationQuitter.class);
        movieViewer = mock(MovieViewer.class);
        movieList = mock(MovieList.class);
        bookList = mock(BookList.class);
        user = mock(User.class);
    }

    @Test
    void shouldDisplayTheMenuBeforeUserInputIsTaken() throws IOException {
        initialize();
        Menu menu = new Menu(null, null, userInput, userOutput, applicationQuitter, movieViewer, movieList, validator, user);

        menu.displayMenu();

        verify(userOutput, times(1)).print("\nSelect any one of the options: \n1: Listing all books\n" +
                "2: Checkout a specified book\n3: Return a book\n4: Quit the application\n5: Listing all movies\n6: Checkout a movie\n7: Show account details\n");
    }

    @Test
    void shouldBeAbleToViewTheListOfBooksFromTheMenuIfChoosesOptionOne() throws IOException {
        initialize();
        Menu menu = new Menu(bookViewer, null, userInput, userOutput, applicationQuitter, movieViewer, movieList, validator, user);
        when(userInput.scanOption()).thenReturn(1, 4);

        menu.showMenu();

        verify(bookViewer, times(1)).printBookDetails();
    }

    @Test
    void shouldNotBeAbleToViewTheListOfBooksFromTheMenuIfChosenOptionIsNotOne() throws IOException {
        initialize();
        Menu menu = new Menu(bookViewer, null, userInput, userOutput, applicationQuitter, movieViewer, movieList, validator, user);
        when(userInput.scanOption()).thenReturn(8, 4);

        menu.showMenu();

        verify(bookViewer, times(0)).printBookDetails();
    }

    @Test
    void shouldShowInvalidOptionMessageIfChosenOptionIsIncorrect() throws IOException {
        initialize();
        when(userInput.scanOption()).thenReturn(8, 4);
        Menu menu = new Menu(bookViewer, null, userInput, userOutput, applicationQuitter, movieViewer, movieList, validator, user);

        menu.showMenu();

        verify(userOutput, times(1)).print("Please select a valid option!");
    }

    @Test
    void shouldBeAbleToCheckoutABookIfChosenOptionTwo() throws IOException {
        initialize();
        when(userInput.scanOption()).thenReturn(2, 4);
        when(validator.isValid()).thenReturn(true);
        Menu menu = new Menu(bookViewer, bookList, userInput, userOutput, applicationQuitter, movieViewer, movieList, validator, user);

        menu.showMenu();

        verify(bookList, times(1)).checkout();
    }

    @Test
    void shouldBeAbleToReturnBookIfChosenOptionIsThree() throws IOException {
        initialize();
        when(userInput.scanOption()).thenReturn(2, 3, 4);
        when(validator.isValid()).thenReturn(true);
        Menu menu = new Menu(bookViewer, bookList, userInput, userOutput, applicationQuitter, movieViewer, movieList, validator, user);

        menu.showMenu();

        verify(bookList, times(1)).returnBook();
    }

    @Test
    void shouldQuitTheApplicationIfOptionFourIsSelected() throws IOException {
        initialize();
        when(userInput.scanOption()).thenReturn(4);
        Menu menu = new Menu(bookViewer, bookList, userInput, userOutput, applicationQuitter, movieViewer, movieList, validator, user);

        menu.showMenu();
    }

    @Test
    void shouldNotQitTheApplicationUntilOptionFourIsSelected() throws IOException {
        initialize();
        when(userInput.scanOption()).thenReturn(1, 4, 2);
        Menu menu = new Menu(bookViewer, bookList, userInput, userOutput, applicationQuitter, movieViewer, movieList, validator, user);

        menu.showMenu();

        verify(bookViewer, times(1)).printBookDetails();
        verify(bookList, times(0)).checkout();
    }

    @Test
    void shouldDisplayTheListOfMoviesWhenOptionFiveIsSelected() throws IOException {
        initialize();
        Menu menu = new Menu(bookViewer, null, userInput, userOutput, applicationQuitter, movieViewer, movieList, validator, user);
        when(userInput.scanOption()).thenReturn(5, 4);

        menu.showMenu();

        verify(movieViewer, times(1)).printMovieDetails();
    }

    @Test
    void shouldBeAbleToCheckoutMovieWhenOptionSixIsSelected() throws IOException {
        initialize();
        when(userInput.scanOption()).thenReturn(6, 4);
        Menu menu = new Menu(bookViewer, bookList, userInput, userOutput, applicationQuitter, movieViewer, movieList, validator, user);

        menu.showMenu();

        verify(movieList, times(1)).checkout();
    }

    @Test
    void shouldViewUserInformationWhenOptionSevenIsSelected() throws IOException {
        initialize();
        when(userInput.scanOption()).thenReturn(7, 4);
        Menu menu = new Menu(bookViewer, bookList, userInput, userOutput, applicationQuitter, movieViewer, movieList, validator, user);

        menu.showMenu();

        verify(user, times(1)).printInformation();
    }
}