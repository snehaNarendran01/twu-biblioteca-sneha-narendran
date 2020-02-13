package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

class MenuTest {
    Validator validator;
    Console console;
    BookViewer bookViewer;
    ApplicationQuitter applicationQuitter;
    MovieViewer movieViewer;
    MovieList movieList;
    BookList bookList;
    User user;

    void initialize() {
        validator = mock(Validator.class);
        console = mock(Console.class);
        bookViewer = mock(BookViewer.class);
        applicationQuitter = mock(ApplicationQuitter.class);
        movieViewer = mock(MovieViewer.class);
        movieList = mock(MovieList.class);
        bookList = mock(BookList.class);
        user = mock(User.class);
    }

    @Test
    void shouldDisplayMenuBeforeLogin() throws IOException {
        initialize();
        Menu menu = new Menu(null, null, console, applicationQuitter, movieViewer, movieList, validator, user);

        menu.displayBeforeLoginMenu();

        verify(console, times(1)).print("\nSelect any one of the options: \n1: Listing all books\n" +
                "2: Listing all movies\n3: Login\n4: Quit the application\n");
    }

    @Test
    void shouldBeAbleToViewTheListOfBooksFromTheMenuBeforeLoginIfChoosesOptionOne() throws IOException {
        initialize();
        Menu menu = new Menu(bookViewer, null, console, applicationQuitter, movieViewer, movieList, validator, user);
        when(console.scanOption()).thenReturn(1);

        menu.showBeforeLoginMenu();

        verify(bookViewer, times(1)).printBookDetails();
    }

    @Test
    void shouldNotBeAbleToViewTheListOfBooksFromTheMenuBeforeIfChosenOptionIsNotOne() throws IOException {
        initialize();
        Menu menu = new Menu(bookViewer, null, console, applicationQuitter, movieViewer, movieList, validator, user);
        when(console.scanOption()).thenReturn(8);

        menu.showBeforeLoginMenu();

        verify(bookViewer, times(0)).printBookDetails();
    }

    @Test
    void shouldBeAbleToViewListOfMoviesBeforeLoginIfOptionChosenIsTwo() throws IOException {
        initialize();
        Menu menu = new Menu(bookViewer, null, console, applicationQuitter, movieViewer, movieList, validator, user);
        when(console.scanOption()).thenReturn(2);

        menu.showBeforeLoginMenu();

        verify(movieViewer, times(1)).printMovieDetails();
    }

    @Test
    void shouldBeAbleToLoginIfOptionSelectedIsThree() throws IOException {
        initialize();
        Menu menu = new Menu(bookViewer, null, console, applicationQuitter, movieViewer, movieList, validator, user);
        when(console.scanOption()).thenReturn(3);

        menu.showBeforeLoginMenu();

        verify(validator, times(1)).isValid();
    }

    @Test
    void shouldQuitApplicationIfOptionIsFour() throws IOException {
        initialize();
        when(console.scanOption()).thenReturn(4);
        Menu menu = new Menu(bookViewer, bookList, console, applicationQuitter, movieViewer, movieList, validator, user);

        menu.showBeforeLoginMenu();

        verify(applicationQuitter, times(1)).exitSystem();
    }

    @Test
    void shouldNotQuitTheApplicationUntilOptionSelectedIsFour() throws IOException {
        initialize();
        when(console.scanOption()).thenReturn(2, 4);
        Menu menu = new Menu(bookViewer, bookList, console, applicationQuitter, movieViewer, movieList, validator, user);
        menu.showBeforeLoginMenu();

        verify(movieViewer, times(1)).printMovieDetails();
        verify(applicationQuitter, times(1)).exitSystem();
    }

    @Test
    void shouldDisplayTheMenuBeforeUserInputIsTaken() throws IOException {
        initialize();
        Menu menu = new Menu(null, null, console, applicationQuitter, movieViewer, movieList, validator, user);

        menu.displayAfterLoginMenu();

        verify(console, times(1)).print("\nSelect any one of the options: \n1: Listing all books\n" +
                "2: Checkout a specified book\n3: Return a book\n4: Quit the application\n5: Listing all movies\n6: Checkout a movie\n7: Show account details\n");
    }

    @Test
    void shouldBeAbleToViewTheListOfBooksFromTheMenuIfChoosesOptionOne() throws IOException {
        initialize();
        Menu menu = new Menu(bookViewer, null, console, applicationQuitter, movieViewer, movieList, validator, user);
        when(console.scanOption()).thenReturn(1, 4);

        menu.showMenu();

        verify(bookViewer, times(1)).printBookDetails();
    }

    @Test
    void shouldNotBeAbleToViewTheListOfBooksFromTheMenuIfChosenOptionIsNotOne() throws IOException {
        initialize();
        Menu menu = new Menu(bookViewer, null, console, applicationQuitter, movieViewer, movieList, validator, user);
        when(console.scanOption()).thenReturn(8, 4);

        menu.showMenu();

        verify(bookViewer, times(0)).printBookDetails();
    }

    @Test
    void shouldShowInvalidOptionMessageIfChosenOptionIsIncorrect() throws IOException {
        initialize();
        when(console.scanOption()).thenReturn(8, 4);
        Menu menu = new Menu(bookViewer, null, console, applicationQuitter, movieViewer, movieList, validator, user);

        menu.showMenu();

        verify(console, times(1)).print("Please select a valid option!");
    }

    @Test
    void shouldBeAbleToCheckoutABookIfChosenOptionTwo() throws IOException {
        initialize();
        when(console.scanOption()).thenReturn(2, 4);
        when(validator.isValid()).thenReturn(true);
        Menu menu = new Menu(bookViewer, bookList, console, applicationQuitter, movieViewer, movieList, validator, user);

        menu.showMenu();

        verify(bookList, times(1)).checkout(user);
    }

    @Test
    void shouldBeAbleToReturnBookIfChosenOptionIsThree() throws IOException {
        initialize();
        when(console.scanOption()).thenReturn(2, 3, 4);
        when(validator.isValid()).thenReturn(true);
        Menu menu = new Menu(bookViewer, bookList, console, applicationQuitter, movieViewer, movieList, validator, user);

        menu.showMenu();

        verify(bookList, times(1)).returnBook(user);
    }

    @Test
    void shouldQuitTheApplicationIfOptionFourIsSelected() throws IOException {
        initialize();
        when(console.scanOption()).thenReturn(4);
        Menu menu = new Menu(bookViewer, bookList, console, applicationQuitter, movieViewer, movieList, validator, user);

        menu.showMenu();
    }

    @Test
    void shouldNotQitTheApplicationUntilOptionFourIsSelected() throws IOException {
        initialize();
        when(console.scanOption()).thenReturn(1, 4, 2);
        Menu menu = new Menu(bookViewer, bookList, console, applicationQuitter, movieViewer, movieList, validator, user);

        menu.showMenu();

        verify(bookViewer, times(1)).printBookDetails();
        verify(bookList, times(0)).checkout(user);
    }

    @Test
    void shouldDisplayTheListOfMoviesWhenOptionFiveIsSelected() throws IOException {
        initialize();
        Menu menu = new Menu(bookViewer, null, console, applicationQuitter, movieViewer, movieList, validator, user);
        when(console.scanOption()).thenReturn(5, 4);

        menu.showMenu();

        verify(movieViewer, times(1)).printMovieDetails();
    }

    @Test
    void shouldBeAbleToCheckoutMovieWhenOptionSixIsSelected() throws IOException {
        initialize();
        when(console.scanOption()).thenReturn(6, 4);
        Menu menu = new Menu(bookViewer, bookList, console, applicationQuitter, movieViewer, movieList, validator, user);

        menu.showMenu();

        verify(movieList, times(1)).checkout();
    }

    @Test
    void shouldBeAbleToViewUserDetailsWhenOptionSevenIsSelected() throws IOException {
        initialize();
        when(console.scanOption()).thenReturn(7, 4);
        when(validator.isValid()).thenReturn(true);
        Menu menu = new Menu(bookViewer, bookList, console, applicationQuitter, movieViewer, movieList, validator, user);

        menu.showMenu();

        verify(user, times(1)).printInformation();
    }
}