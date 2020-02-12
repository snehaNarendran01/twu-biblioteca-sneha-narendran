package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

class MenuTest {
    Validator validator = mock(Validator.class);

    @Test
    void shouldBeAbleToViewTheListOfBooksFromTheMenuIfChoosesOptionOne() throws IOException {
        UserInput userInput = mock(UserInput.class);
        UserOutput userOutput = mock(UserOutput.class);
        ApplicationQuitter applicationQuitter = mock(ApplicationQuitter.class);
        BookViewer bookViewer = mock(BookViewer.class);
        MovieViewer movieViewer = mock(MovieViewer.class);
        MovieList movieList = mock(MovieList.class);
        Menu menu = new Menu(bookViewer, null, userInput, userOutput, applicationQuitter, movieViewer, movieList, validator);
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
        MovieViewer movieViewer = mock(MovieViewer.class);
        MovieList movieList = mock(MovieList.class);
        Menu menu = new Menu(bookViewer, null, userInput, userOutput, applicationQuitter, movieViewer, movieList, validator);
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
        MovieViewer movieViewer = mock(MovieViewer.class);
        MovieList movieList = mock(MovieList.class);
        Menu menu = new Menu(bookViewer, null, userInput, userOutput, applicationQuitter, movieViewer, movieList, validator);

        menu.showMenu();

        verify(userOutput, times(1)).print("Please select a valid option!");
    }

    @Test
    void shouldBeAbleToCheckoutABookIfChosenOptionTwo() throws IOException {
        UserInput userInput = mock(UserInput.class);
        ApplicationQuitter applicationQuitter = mock(ApplicationQuitter.class);
        UserOutput userOutput = mock(UserOutput.class);
        when(userInput.scanOption()).thenReturn(2, 4);
        BookViewer bookViewer = mock(BookViewer.class);
        BookList bookList = mock(BookList.class);
        MovieViewer movieViewer = mock(MovieViewer.class);
        MovieList movieList = mock(MovieList.class);
        Validator validator = mock(Validator.class);
        when(validator.isValid()).thenReturn(true);
        Menu menu = new Menu(bookViewer, bookList, userInput, userOutput, applicationQuitter, movieViewer, movieList, validator);

        menu.showMenu();

        verify(bookList, times(1)).checkout();
    }

    @Test
    void shouldBeAbleToReturnBookIfChosenOptionIsThree() throws IOException {
        UserInput userInput = mock(UserInput.class);
        UserOutput userOutput = mock(UserOutput.class);
        ApplicationQuitter applicationQuitter = mock(ApplicationQuitter.class);
        when(userInput.scanOption()).thenReturn(2, 3, 4);
        BookViewer bookViewer = mock(BookViewer.class);
        BookList bookList = mock(BookList.class);
        MovieViewer movieViewer = mock(MovieViewer.class);
        MovieList movieList = mock(MovieList.class);
        when(validator.isValid()).thenReturn(true);
        Menu menu = new Menu(bookViewer, bookList, userInput, userOutput, applicationQuitter, movieViewer, movieList, validator);
        menu.showMenu();

        verify(bookList, times(1)).returnBook();
    }

    @Test
    void shouldDisplayTheMenuBeforeUserInputIsTaken() throws IOException {
        UserInput userInput = mock(UserInput.class);
        UserOutput userOutput = mock(UserOutput.class);
        ApplicationQuitter applicationQuitter = mock(ApplicationQuitter.class);
        MovieViewer movieViewer = mock(MovieViewer.class);
        MovieList movieList = mock(MovieList.class);
        Menu menu = new Menu(null, null, userInput, userOutput, applicationQuitter, movieViewer, movieList, validator);

        menu.displayMenu();

        verify(userOutput, times(1)).print("\nSelect any one of the options: \n1: Listing all books\n" +
                "2: Checkout a specified book\n3: Return a book\n4: Quit the application\n5: Listing all movies\n6: Checkout a movie\n");
    }

    @Test
    void shouldQuitTheApplicationIfOptionFourIsSelected() throws IOException {
        ApplicationQuitter applicationQuitter = mock(ApplicationQuitter.class);
        UserInput userInput = mock(UserInput.class);
        UserOutput userOutput = mock(UserOutput.class);
        when(userInput.scanOption()).thenReturn(4);
        BookViewer bookViewer = mock(BookViewer.class);
        BookList bookList = mock(BookList.class);
        MovieViewer movieViewer = mock(MovieViewer.class);
        MovieList movieList = mock(MovieList.class);
        Menu menu = new Menu(bookViewer, bookList, userInput, userOutput, applicationQuitter, movieViewer, movieList, validator);

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
        MovieViewer movieViewer = mock(MovieViewer.class);
        MovieList movieList = mock(MovieList.class);
        Menu menu = new Menu(bookViewer, bookList, userInput, userOutput, applicationQuitter, movieViewer, movieList, validator);

        menu.showMenu();

        verify(bookViewer, times(1)).printBookDetails();
        verify(bookList, times(0)).checkout();
    }

    @Test
    void shouldDisplayTheListOfMoviesWhenOptionFiveIsSelected() throws IOException {
        UserInput userInput = mock(UserInput.class);
        UserOutput userOutput = mock(UserOutput.class);
        BookViewer bookViewer = mock(BookViewer.class);
        ApplicationQuitter applicationQuitter = mock(ApplicationQuitter.class);
        MovieViewer movieViewer = mock(MovieViewer.class);
        MovieList movieList = mock(MovieList.class);
        Menu menu = new Menu(bookViewer, null, userInput, userOutput, applicationQuitter, movieViewer, movieList, validator);
        when(userInput.scanOption()).thenReturn(5, 4);

        menu.showMenu();

        verify(movieViewer, times(1)).printMovieDetails();
    }

    @Test
    void shouldBeAbleToCheckoutMovieWhenOptionSixIsSelected() throws IOException {
        UserInput userInput = mock(UserInput.class);
        ApplicationQuitter applicationQuitter = mock(ApplicationQuitter.class);
        UserOutput userOutput = mock(UserOutput.class);
        when(userInput.scanOption()).thenReturn(6, 4);
        BookViewer bookViewer = mock(BookViewer.class);
        BookList bookList = mock(BookList.class);
        MovieViewer movieViewer = mock(MovieViewer.class);
        MovieList movieList = mock(MovieList.class);
        Menu menu = new Menu(bookViewer, bookList, userInput, userOutput, applicationQuitter, movieViewer, movieList, validator);

        menu.showMenu();

        verify(movieList, times(1)).checkout();
    }
}